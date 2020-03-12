package com.aaa.lee.repast.base;

import static com.aaa.lee.repast.status.LoginStatus.LOGIN_FAILED;
import static com.aaa.lee.repast.status.LoginStatus.LOGIN_SUCCESS;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/9 20:42
 * @Description
 **/
public class BaseController {

    /**
     * @author Seven Lee
     * @description
     *      登录成功，使用系统消息
     * @param []
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData success() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，自定义返回消息
     * @param [msg]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData success(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，使用系统消息，自定义返回值
     * @param [data]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData success(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，自定义消息，自定义返回值
     * @param [msg, data]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData success(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录失败，返回系统消息
     * @param []
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData failed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    // TODO 该类未完成，自行完成剩余的方法

}
