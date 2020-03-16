package com.aaa.lee.repast.mapper;


import com.aaa.lee.repast.model.MemberReceiveAddress;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//这个mapper也要标识成spring管理的类
@Repository(value = "收货地址")
public interface MemberReceiveAddressMapper extends Mapper<MemberReceiveAddress> {
    /**
     * 根据 memeberid
     * 查询收货地址
     * @param memberId
     * @return
     */
    List<MemberReceiveAddress> selectMemberReceiveAddressByMemberid(Long memberId);
    /**
     * 新增收货地址
     * @param memberReceiveAddress
     * @return
     */

    boolean AddAddress(MemberReceiveAddress memberReceiveAddress);

    /**
     *修改收货地址
     * @param memberReceiveAddress
     * @return
     */
    boolean updateAddress(MemberReceiveAddress memberReceiveAddress);

    /**
     * 根据收货地址id删除
     * @param id
     * @return
     */

    boolean delAddress(@PathVariable("id")Long id);
}