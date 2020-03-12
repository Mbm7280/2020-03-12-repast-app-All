package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.mapper.LoginLogMapper;
import com.aaa.lee.repast.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/11 11:51
 * @Description
 **/
@Service
public class LoginLogService extends BaseService<LoginLog> {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public Mapper<LoginLog> getMapper() {
        return loginLogMapper;
    }

    /**
     * @author Seven Lee
     * @description
     *      保存登录日志
     * @param [loginLog]
     * @date 2020/3/11
     * @return java.lang.Boolean
     * @throws
    **/
    public Boolean addLoginLog(LoginLog loginLog) {
        try {
            Integer saveResult = super.save(loginLog);
            if(saveResult > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
