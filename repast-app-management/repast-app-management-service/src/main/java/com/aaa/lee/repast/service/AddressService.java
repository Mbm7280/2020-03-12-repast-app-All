package com.aaa.lee.repast.service;


import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.mapper.MemberReceiveAddressMapper;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.status.StatusEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Service
public class AddressService extends BaseService<MemberReceiveAddress> {

    @Autowired
    private MemberReceiveAddressMapper memberReceiveAddressMapper;

    @Override
    public Mapper<MemberReceiveAddress> getMapper() {
        return memberReceiveAddressMapper;
    }

    /**
     * 根据 memberReceiveAddress
     * 查询收货地址
     * @param memberid
     * @return
     */
    public ResultData selectMemberReceiveAddressByMemberid(Long memberid){
        if (memberid !=null){
            List<MemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressMapper.selectMemberReceiveAddressByMemberid(memberid);
            if (memberReceiveAddressList !=null && memberReceiveAddressList.equals("")){
                return new ResultData(StatusEnums.SUCCESS.getCode(),StatusEnums.SUCCESS.getMsg(),memberReceiveAddressList);
            }
        }
        return new ResultData(StatusEnums.FAILED.getCode(),StatusEnums.FAILED.getMsg());
    }

    /**
     * 新增收货地址
     *
     * @param memberReceiveAddress
     * @return
     */

    public Boolean AddAddress(MemberReceiveAddress memberReceiveAddress) {
        int res = getMapper().insert(memberReceiveAddress);
        return res>0;

    }

    /**
     * 修改收货地址
     *
     * @param memberReceiveAddress
     * @return
     */
    public Boolean updateAddress(MemberReceiveAddress memberReceiveAddress) {
        int update = getMapper().updateByPrimaryKey(memberReceiveAddress);
        return update>0;
    }

    /**
     * 根据收货地址id删除
     *
     * @param id
     * @return
     */
    public Boolean delAddress(@PathVariable("id") Long id) {
        int delete = getMapper().deleteByPrimaryKey(id);
        return delete>0;
    }

}
