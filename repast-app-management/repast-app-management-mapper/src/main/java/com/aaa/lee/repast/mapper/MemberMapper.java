package com.aaa.lee.repast.mapper;

import com.aaa.lee.repast.model.Member;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface MemberMapper extends Mapper<Member> {

    /**
     *  根据 openId 查询
     * @param openId
     * @return
     */
    Member selectMemberByOpenId(String openId);

    /**
     * 根据 memberid
     * 查询可用优惠卷
     * @param memberid
     * @return
     */
    List<Member> selectAllCouponsByMemberId(Long memberid);

    /**
     * 根据 memberid
     * 查询过期优惠卷
     * @param memberid
     * @return
     */
    List<Member> selectOverdueCouponsByMemberId(Long memberid);

    /**
     * 根据 memberid
     * 查询快到期的优惠劵
     * @param memberid
     * @return
     */
    List<Member> selectCountDownAndWarnByMemberId(Long memberid);

    /**
     * 根据 memberid
     * 查询已经使用的优惠劵
     * @param memberid
     * @return
     */
    List<Member> selectAlreadyUseCoupons(Long memberid);

}
