package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.ShopComment;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 商品评价
 */

@RestController
@Api(value = "商品评价",tags = "商品评价接口（提供用户的商品评价信息）")
public class ShopCommentController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 新增评价
     * @param shopComment
     * @return
     */
    @PostMapping("/AddComment")
    @ApiOperation(value = "新增地址",notes = "用户执行新增评价（新增评价）")
    public ResultData AddComment(ShopComment shopComment){
        //调用api工程（feign）
        return repastService.AddComment(shopComment);
    }

    /**
     * 删除评价
     * @param id
     * @return
     */
    @GetMapping("/DelComment/{id}")
    @ApiOperation(value = "删除评价",notes = "用户执行删除评价（删除评价）")
    public ResultData DelComment(@PathVariable("id") Long id){
        return repastService.DelComment(id);
    }
}
