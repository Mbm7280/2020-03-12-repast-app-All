package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.mapper.ShopCommentMapper;
import com.aaa.lee.repast.model.ShopComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

@Service
public class ShopCommentService extends BaseService<ShopComment> {

    @Autowired
    private ShopCommentMapper shopCommentMapper;

    @Override
    public Mapper<ShopComment> getMapper() {
        return shopCommentMapper;
    }

    /**
     * 执行新增评价操作
     * @param shopComment
     * @return
     */
    public Boolean AddComment(ShopComment shopComment){
        int insert = getMapper().insert(shopComment);
        return insert>0;
    }

    /**
     * 执行删除评价操作
     * @param id
     * @return
     */
    public Boolean DelComment(@PathVariable("id") Long id){
        int delete = getMapper().deleteByPrimaryKey(id);
        return delete>0;
    }
}
