package com.aaa.lee.repast.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/9 20:43
 * @Description
 **/
@Data
public class ResultData<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T data;

    public ResultData(String code, String msg, String detail, T data) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
        this.data = data;
    }

    public ResultData(String code, String msg, String detail) {
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public ResultData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultData() {
    }
}
