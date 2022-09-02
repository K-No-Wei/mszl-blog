package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mszlu.blog.vo.TagVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
public interface TagService extends IService<Tag> {
    List<TagVo> findTagsByArticleId(Long id);

    List<TagVo> hot(int limit);
}
