package com.aaa.lee.repast.mapper;

import com.aaa.lee.repast.model.ShopComment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

@Repository(value = "商品评价")
public interface ShopCommentMapper extends Mapper<ShopComment> {

    /**
     * 新增评价
     * @param shopComment
     * @return
     */

    boolean AddComment(ShopComment shopComment);

    /**
     * 删除评价
     * @param id
     * @return
     */

    boolean DelComment(@PathVariable("id") Long id);

}
