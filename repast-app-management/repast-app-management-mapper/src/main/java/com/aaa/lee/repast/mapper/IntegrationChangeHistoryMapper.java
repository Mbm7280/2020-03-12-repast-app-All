package com.aaa.lee.repast.mapper;

import com.aaa.lee.repast.model.IntegrationChangeHistory;
import tk.mybatis.mapper.common.Mapper;

public interface IntegrationChangeHistoryMapper extends Mapper<IntegrationChangeHistory> {

    /**
     * 根据 memeberid
     * 查询 积分历史记录
     * @param memberid
     * @return
     */
    IntegrationChangeHistory selectIntegrationChangeHistoryByMemberid(Long memberid);

}
