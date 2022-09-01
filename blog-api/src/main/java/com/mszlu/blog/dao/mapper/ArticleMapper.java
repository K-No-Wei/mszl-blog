package com.mszlu.blog.dao.mapper;

import com.mszlu.blog.dao.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
