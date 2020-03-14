package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.mapper.IntegrationChangeHistoryMapper;
import com.aaa.lee.repast.model.IntegrationChangeHistory;
import com.aaa.lee.repast.status.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
* @Package: com.aaa.lee.repast.service
* @ClassName: IntegrationChangeHistoryService
* @Description: service - IntegrationChangeHostory
* @Author: mbm
* @date: 2020/3/14 10:15
* @Version: 1.0
*/
@Service
public class IntegrationChangeHistoryService extends BaseService<IntegrationChangeHistory> {

    @Autowired
    private IntegrationChangeHistoryMapper integrationChangeHistoryMapper;

    @Override
    public Mapper<IntegrationChangeHistory> getMapper() {
        return integrationChangeHistoryMapper;
    }

    /**
     * @author mbm X
     * @methodname : selectIntegrationChangeHistoryByMemberid
     * @description : 查询 积分历史记录
     * @param memberid :
     * @return : com.aaa.lee.repast.base.ResultData
     * @date : 2020/3/14 10:16
     */
    public ResultData selectIntegrationChangeHistoryByMemberid(Long memberid){

        if(memberid > 0 && !memberid.equals("") && null != memberid){
            IntegrationChangeHistory integrationChangeHistory = integrationChangeHistoryMapper.selectIntegrationChangeHistoryByMemberid(memberid);
            if(null != integrationChangeHistory && !integrationChangeHistory.equals("")){
                return new ResultData(StatusEnums.SUCCESS.getCode(),StatusEnums.SUCCESS.getMsg(),integrationChangeHistory);
            }
        }

        return new ResultData(StatusEnums.FAILED.getCode(),StatusEnums.FAILED.getMsg());

    }

}
