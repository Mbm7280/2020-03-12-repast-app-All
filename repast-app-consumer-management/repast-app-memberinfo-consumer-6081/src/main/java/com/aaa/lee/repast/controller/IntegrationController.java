package com.aaa.lee.repast.controller;


import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Package: com.aaa.lee.repast.controller
 * @ClassName: IntegrationControlle
 * @Description: controller - integration
 * @Author: mbm
 * @date: 2020/3/14 10:32
 * @Version: 1.0
 */
@RestController
@Api(value = "积分管理",tags = "提供所有有关积分的操作")
public class IntegrationController {

    @Autowired
    private IRepastService repastService;

    /**
     * @author mbm X
     * @methodname : selectIntegrationChangeHistoryByMemberid
     * @description : 查询 积分历史记录
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/14 10:33
     */
    @GetMapping("/selectIntegrationHistory")
    @ApiOperation(value = "查询积分的变动历史记录")
    public ResultData selectIntegrationChangeHistoryByMemberid(Long memberid){
        return repastService.selectIntegrationChangeHistoryByMemberid(memberid);
    }

}
