package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.LoginLog;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.LoginLogService;
import com.aaa.lee.repast.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:53
 * @Description
 **/
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private LoginLogService loginLogService;

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
    public Boolean doLogin(@RequestBody Member member) {
        return memberService.doLogin(member);
    }

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
    public Boolean saveLog(@RequestBody LoginLog loginLog) {
        return loginLogService.addLoginLog(loginLog);
    }

    /**
     * @author mbm X
     * @methodname : selectAllCouponsByMemberId
     * @description : 查询有效优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 16:19
     */
    @GetMapping("/selectCous")
    public ResultData selectAllCouponsByMemberId(Long memberid){
        return memberService.selectAllCouponsByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectOverdueCouponsByMemberId
     * @description : 查询过期优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 18:07
     */
    @GetMapping("/selectOverdueCous")
    public ResultData selectOverdueCouponsByMemberId(Long memberid){
        return memberService.selectOverdueCouponsByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectCountDownAndWarnByMemberId
     * @description : 查询快到期的优惠劵
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 19:39
     */
    @GetMapping("/selectCountDownAndWarnCous")
    public ResultData selectCountDownAndWarnByMemberId(Long memberid){
        return memberService.selectCountDownAndWarnByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectAlreadyUseCoupons
     * @description : 查询已经使用的优惠卷
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/13 19:55
     */
    @GetMapping("/selectAlreadyUseCoupons")
    public ResultData selectAlreadyUseCoupons(Long memberid){
        return memberService.selectCountDownAndWarnByMemberId(memberid);
    }

    /**
     * @author mbm X
     * @methodname : selectIntegrationBymemberId
     * @description : 查询个人现有积分
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/14 9:32
     */
    @GetMapping("/selectIntegrationNow")
    public ResultData selectIntegrationBymemberId(Long memberid){
        return memberService.selectIntegrationBymemberId(memberid);
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
    public ResultData selectOneByOpenId(String openId){
        return memberService.selectOneByOpenId(openId);
    }


    /**
     * @Author zhang TF
     * @Description
     *          通过对象修改个人信息
     * @Date  2020/3/15
     * @Param [member]
     * @return com.aaa.lee.repast.base.ResultData
     **/
    @GetMapping("/updateMember")
    public ResultData updateMember(Member member){
        return memberService.updateMember(member);
    }

}
