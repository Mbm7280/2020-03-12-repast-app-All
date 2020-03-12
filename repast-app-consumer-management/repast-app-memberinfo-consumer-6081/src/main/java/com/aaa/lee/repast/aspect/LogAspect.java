package com.aaa.lee.repast.aspect;

import com.aaa.lee.repast.annotation.LoginLogAnnotation;
import com.aaa.lee.repast.model.LoginLog;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.IRepastService;
import com.aaa.lee.repast.utils.DateUtil;
import com.aaa.lee.repast.utils.IPForAddressUtil;
import com.aaa.lee.repast.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import static com.aaa.lee.repast.staticstatus.StaticCode.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/11 10:37
 * @Description
 *      Slf4j:当使用切面的时候，spring5必须要求去添加log4j日志--->simple log4j
 **/
@Slf4j
@Component
@Aspect
public class LogAspect {

    @Autowired
    private IRepastService repastService;

    /**
     * @author Seven Lee
     * @description
     *      就是为了定义切面，也就是说让AOP在哪里生效
     *      也就是说当AOP检测到LoginLogAnnotation注解的时候，被该注解所标识的方法就会执行
     *      切面业务代码
     * @param []
     * @date 2020/3/11
     * @return void
     * @throws
    **/
    @Pointcut("@annotation(com.aaa.lee.repast.annotation.LoginLogAnnotation)")
    public void pointcut() {
        // TODO nothing todo
    }

    /**
     * @author Seven Lee
     * @description
     *      定义环形切面(具体要执行业务逻辑的代码)
     *      ProceedingJoinPoint:封装了目标路径(被LoginLogAnnotation注解所标识方法)
     *      中的所有参数
     *      也就是说我可以通过这个ProceedingJoinPoint参数获取(获取目标路径的方法名，方法参数个数，方法参数类型，方法
     *      返回值，方法参数的值)
     * @param [proceedingJoinPoint]
     * @date 2020/3/11
     * @return java.lang.Object
     * @throws
    **/
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        // 获取Request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        // 获取用户的ip地址(HttpServletRequest对象)
        String ipAddr = IPUtil.getIpAddr(request);

        // 如何获取MemberController中doLogin方法中的Member参数对象
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }

        // 如何获取operationType和operationName值
        // 1.获取目标路径(只能指的是类-->MemberController)的全限定名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        // 2.通过反射获取类对象(Class)
        Class targetClass = Class.forName(className);
        // 3.获取所需要切的具体方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 4.MemberController中所有的方法
        Method[] methods = targetClass.getMethods();
        String operationType = "";
        String operationName = "";
        for (Method method : methods) {
            // 5.判断如果方法名一致，则就是所需要的方法(不严谨)
            if(method.getName().equals(methodName)) {
                // 说明这个方法就是咱们所需要的方法
                // 因为方法可能出现重载，一旦出现重载，则方法名一样
                // 需要再次判断，方法参数的类型个数是否一致
                // 获取方法的参数类型个数
                Class[] parameterTypes = method.getParameterTypes();
                // 6.再次判断
                if(parameterTypes.length == args.length) {
                    operationType = method.getAnnotation(LoginLogAnnotation.class).operationType();
                    operationName = method.getAnnotation(LoginLogAnnotation.class).operationName();
                    break;
                }
            }
        }

        /**
         * 第二种方式:
         *      通过用户的ip地址来获取用户的地理位置
         *      会使用到一个外部API(百度)
         *      ---->自己去定义一个工具类(向百度api去发送请求--->再去接收百度api所响应回来的数据)
         */
        // 百度api只能获取静态公网ip(俗称服务器的ip)--->或者获取运营商的手机ip
        // 只能模拟ip地址
        Member member = new Member(); // 实例化 member  获取 openId
        Map<String, Object> addressMap = IPForAddressUtil.getAddresses(TEST_IP, ENCODING);
        LoginLog loginLog = new LoginLog();
        // 在member对象中
        loginLog.setProvince((String)addressMap.get(PROVINCE)); // 省份信息
        loginLog.setLoginType(3);// 登录类型(3:小程序)
        loginLog.setCity((String)addressMap.get(CITY));// 城市信息
        String dateString = DateUtil.formatDate(new Date(), FORMAT_DATE);
        loginLog.setCreateTime(dateString);// 日志创建时间
        loginLog.setIp(ipAddr);// 用户ip地址
        loginLog.setOpenId(member.getOpenId());// 微信所传递过来的openId
        // 在LoginLog注解中
        loginLog.setOperationType(operationType);// 操作类型
        loginLog.setOperationName(operationName);// 具体操作事项

        // OK
        // TODO 自己把剩余的参数获取到setProvince,setCity,setOpenId


        Boolean ifSuccess = repastService.saveLog(loginLog);
        if(ifSuccess) {
            return result; // 从切面重新返回到controller中
        }
        return null;// 表示直接代码结束，不再返回controller
    }


}
