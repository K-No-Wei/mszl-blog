package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mszlu.blog.vo.ArticleVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PageParams;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查找文章列表
     * @param pageParams
     * @return
     */
    List<ArticleVo> listArticle(PageParams pageParams);

    /**
     * 查找最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticle(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    Result findArticleById(Long id);
}
