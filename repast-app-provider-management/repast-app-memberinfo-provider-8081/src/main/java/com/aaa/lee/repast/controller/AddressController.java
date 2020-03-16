package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AddressController extends BaseController {
    public static final String memberId = "memeberId";
    @Autowired
    private AddressService addressService;

    /**
     * 根据用户id查收货地址
     * @param memberId
     * @return
     */

    @GetMapping("/address")
    public  ResultData selectMemberReceiveAddressByMemberid(@RequestParam(value = "memberId") Long memberId){
        return addressService.selectMemberReceiveAddressByMemberid(memberId);
    }

    /**
     * 新增收货地址
     *
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/addAddress")
    public ResultData AddAddress(@RequestBody MemberReceiveAddress memberReceiveAddress) {

        Boolean b = addressService.AddAddress(memberReceiveAddress);
        if(b){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * 修改收货地址
     *
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/updateAddress")
    public ResultData updateAddress(@RequestBody MemberReceiveAddress memberReceiveAddress) {
        return addressService.updateAddress(memberReceiveAddress)?super.operationSuccess():super.operationFailed();
    }

    /**
     * 根据收货地址id删除
     *
     * @param id
     * @return
     */
    @GetMapping("/delAddress/{id}")
    public ResultData delAddress(@PathVariable("id") Long id) {
        Boolean del = addressService.delAddress(id);
        if (del){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }

    }
}
