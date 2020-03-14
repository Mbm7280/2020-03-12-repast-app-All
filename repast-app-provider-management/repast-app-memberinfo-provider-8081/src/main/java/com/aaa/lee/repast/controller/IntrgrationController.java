package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.service.IntegrationChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Package: com.aaa.lee.repast.controller
* @ClassName: IntrgrationController
* @Description: controller - integration
* @Author: mbm
* @date: 2020/3/14 10:24
* @Version: 1.0
*/
@RestController
public class IntrgrationController {

    @Autowired
    IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * @author mbm X
     * @methodname : selectIntegrationChangeHistoryByMemberid
     * @description : 查询 积分历史记录
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/14 10:25
     */
    @GetMapping("/selectIntegrationHistory")
    public ResultData selectIntegrationChangeHistoryByMemberid(Long memberid){
        return integrationChangeHistoryService.selectIntegrationChangeHistoryByMemberid(memberid);
    }

}
