package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.annotation.LoginLogAnnotation;
import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:13
 * @Description
 **/
@RestController
@Api(value = "用户信息", tags = "用户信息接口(提供用户所欲有关操作)")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     *      member这个参数是由微信过来的--->并不知道自己数据库中的member_id是多少
     *      只会传递open_id
     * @param [member]
     * @date 2020/3/10
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
    **/
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录", notes = "用户执行登录操作(接收微信端传递数据)")
    @LoginLogAnnotation(operationType = "登录操作", operationName = "普通用户登录")
    public ResultData doLogin(Member member) {
        // 需要调用api工程(feign)
        Boolean ifSuccess = repastService.doLogin(member);
        if(ifSuccess) {
            return super.success();
        }
        return super.failed();
    }

    /**
     * @author mbm X
     * @methodname : selectAllCouponsByMemberId
     * @description : 查询有效优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 16:25
     */
    @ApiOperation(value = "优惠卷查询")
    @GetMapping("/selectCous")
    public ResultData selectAllCouponsByMemberId(Long memberid){
       return repastService.selectAllCouponsByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectOverdueCouponsByMemberId
     * @description : 查询过期优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 19:59
     */
    @GetMapping("/selectOverdueCous")
    @ApiOperation(value = "查询过期优惠卷")
    public ResultData selectOverdueCouponsByMemberId(Long memberid){
        return repastService.selectOverdueCouponsByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectCountDownAndWarnByMemberId
     * @description : 查询快到期的优惠劵
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 20:00
     */
    @GetMapping("/selectCountDownAndWarnCous")
    @ApiOperation(value = "查询快到期的优惠劵")
    public ResultData selectCountDownAndWarnByMemberId(Long memberid){
        return repastService.selectCountDownAndWarnByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectAlreadyUseCoupons
     * @description : 查询已经使用的优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 20:00
     */
    @GetMapping("/selectAlreadyUseCoupons")
    @ApiOperation(value = "查询已经使用的优惠卷")
    public ResultData selectAlreadyUseCoupons(Long memberid){
        return repastService.selectCountDownAndWarnByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectIntegrationBymemberId
     * @description : 查询个人现有积分
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/14 10:28
     */
    @GetMapping("/selectIntegrationNow")
    @ApiOperation(value = "查询个人现有积分")
    public ResultData selectIntegrationBymemberId(Long memberid){
        return repastService.selectIntegrationBymemberId(memberid);
    }


    /**
     * @Author zhang TF
     * @Description
     *          查询个人信息
     * @Date  2020/3/15
     * @Param [openId]
     * @return com.aaa.lee.repast.base.ResultData
     **/
    @GetMapping("/selectOneByOpenId")
    @ApiOperation(value = "个人信息查询")
    public ResultData selectOneByOpenId(String openId){
        return repastService.selectOneByOpenId(openId);
    }



    /**
     * @Author zhang TF
     * @Description
     *      通过对象修改个人信息
     * @Date  2020/3/15
     * @Param [member]
     * @return com.aaa.lee.repast.base.ResultData
     **/
    @GetMapping("/updateMember")
    @ApiOperation(value = "通过对象修改个人信息")
    @LoginLogAnnotation(operationType = "修改操作",operationName = "修改个人信息")
    public ResultData updateMember(Member member){
        return repastService.updateMember(member);
    }

}
