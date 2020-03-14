package com.aaa.lee.repast.mapper;

import com.aaa.lee.repast.model.Coupon;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CouponMapper extends Mapper<Coupon> {

    /**
     * 个人中心
     * 查询可用的优惠卷
     *      根据 时间段
     * @return
     */
    List<Coupon> selectAvailableByTimeZone();

}
