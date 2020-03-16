package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.LoginLog;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.model.ShopComment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:16
 * @Description
 *      springcloud2.x之后，在feign中只能出现一次
 *      value的值非常重要:
 *          这个value的值，就取决于是否可以调用到provider中的值
 *              !!!! value的值指向的就是provider项目中application.properties文件中所配置的spring.application.name !!!!
 *              !!!! api中所写的接口，一定要和provider的Controller中的方法一模一样 !!!!
 **/
@FeignClient(value = "memberinfo-interface")
//@FeignClient(value = "memberinfo-interface", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [member]
     * @date 2020/3/10
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/doLogin")
    Boolean doLogin(@RequestBody Member member);

    /**
     * @author Seven Lee
     * @description
     *      登录日志保存
     * @param [loginLog]
     * @date 2020/3/11
     * @return java.lang.Boolean
     * @throws
    **/
    @PostMapping("/saveLog")
    Boolean saveLog(@RequestBody LoginLog loginLog);

    /**
     * @author mbm X
     * @methodname : selectAllCouponsByMemberId
     * @description : 查询有效优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 16:23
     */
    @GetMapping("/selectCous")
    ResultData selectAllCouponsByMemberId(@RequestParam("memberid") Long memberid);

    /**
     * @author mbm X
     * @methodname : selectOverdueCouponsByMemberId
     * @description : 查询过期优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 19:57
     */
    @GetMapping("/selectOverdueCous")
    ResultData selectOverdueCouponsByMemberId(@RequestParam("memberid") Long memberid);

    /**
     * @author mbm X
     * @methodname : selectCountDownAndWarnByMemberId
     * @description : 查询快到期的优惠劵
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 19:58
     */
    @GetMapping("/selectCountDownAndWarnCous")
     ResultData selectCountDownAndWarnByMemberId(@RequestParam ("memberid") Long memberid);

    /**
     * @author mbm X
     * @methodname : selectAlreadyUseCoupons
     * @description : 查询已经使用的优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 19:58
     */
    @GetMapping("/selectAlreadyUseCoupons")
     ResultData selectAlreadyUseCoupons(@RequestParam ("memberid") Long memberid);


    /**
     * @author mbm X
     * @methodname : selectIntegrationBymemberId
     * @description : 查询个人现有积分
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/14 10:28
     */
    @GetMapping("/selectIntegrationNow")
     ResultData selectIntegrationBymemberId(@RequestParam("memberid") Long memberid);

    /**
     * @author mbm X
     * @methodname : selectIntegrationChangeHistoryByMemberid
     * @description : 查询 积分历史记录
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/14 10:29
     */
    @GetMapping("/selectIntegrationHistory")
     ResultData selectIntegrationChangeHistoryByMemberid(@RequestParam("memberid") Long memberid);

    /**
     * 根据用户id查收货地址
     * @param memberId
     * @return
     */
    @GetMapping("/address")
    ResultData selectMemberReceiveAddressByMemberid (@RequestParam("memeberId") Long memberId);

    /**
     * 新增收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/addAddress")
    ResultData AddAddress(MemberReceiveAddress memberReceiveAddress);

    /**
     *修改收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/updateAddress")
    ResultData updateAddress(MemberReceiveAddress memberReceiveAddress);

    /**
     * 根据收货地址id删除
     * @param id
     * @return
     */
    @GetMapping("/delAddress/{id}")
    ResultData delAddress(@PathVariable("id")Long id);

    /**
     * 新增评价
     * @param shopComment
     * @return
     */
    @PostMapping("/AddComment")
    ResultData AddComment(ShopComment shopComment);

    /**
     * 删除评价
     * @param id
     * @return
     */
    @GetMapping("/DelComment/{id}")
    ResultData DelComment(@PathVariable("id") Long id);
}
