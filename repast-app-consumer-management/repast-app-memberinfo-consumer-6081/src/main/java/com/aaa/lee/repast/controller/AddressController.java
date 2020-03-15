package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "收货地址信息",tags = "收货地址接口(提供用户收货地址信息")
public class AddressController extends BaseController {
    @Autowired
    private IRepastService repastService;

    /**
     * 查询所有收货地址
     * @param memberId
     * @return
     */
    @GetMapping("/address")
    @ApiOperation(value = "查询所有收货地址", notes = "用户执行查询所有收货地址(查询所有收货地址)")
    public ResultData selectMemberReceiveAddressByMemberid(Long memberId){
        return repastService.selectMemberReceiveAddressByMemberid(memberId);
    }

    /**
     * 新增收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/addAddress")
    @ApiOperation(value = "增加收货地址", notes = "用户执行增加收货地址(增加收货地址)")
    public ResultData AddAddress(MemberReceiveAddress memberReceiveAddress){
        return repastService.AddAddress(memberReceiveAddress);
    }

    /**
     * 修改收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/updateAddress")
    @ApiOperation(value = "修改收货地址", notes = "用户执行修改收货地址(修改收货地址)")
    public ResultData updateAddress(MemberReceiveAddress memberReceiveAddress){
        return repastService.updateAddress(memberReceiveAddress);
    }

    /**
     * 根据收货地址id删除数据
     * @param id
     * @return
     */
    @GetMapping("/delAddress/{id}")
    @ApiOperation(value = "删除收货地址", notes = "用户执行删除收货地址(删除收货地址)")
    public ResultData delAddress(@PathVariable("id") Long id){
        return repastService.delAddress(id);
    }

}
