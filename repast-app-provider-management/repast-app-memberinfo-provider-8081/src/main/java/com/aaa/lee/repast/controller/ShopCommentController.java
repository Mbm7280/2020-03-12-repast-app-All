package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.ShopComment;
import com.aaa.lee.repast.service.ShopCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopCommentController extends BaseController {

    @Autowired
    private ShopCommentService shopCommentService;



    /**
     * 执行新增评价操作
     * @param shopComment
     * @return
     */
    @PostMapping("/AddComment")
    public ResultData AddComment(@RequestBody ShopComment shopComment){
        Boolean a = shopCommentService.AddComment(shopComment);
        if (a ){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * 执行删除评价操作
     * @param id
     * @return
     */
    @GetMapping("/DelComment/{id}")
    public ResultData DelComment(@PathVariable("id") Long id){
        Boolean del = shopCommentService.DelComment(id);
        if (del) {
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }
}
