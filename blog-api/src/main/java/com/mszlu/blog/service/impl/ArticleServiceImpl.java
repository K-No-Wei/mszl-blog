package com.mszlu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.mapper.TagMapper;
import com.mszlu.blog.dao.pojo.Article;
import com.mszlu.blog.dao.mapper.ArticleMapper;
import com.mszlu.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.service.TagService;
import com.mszlu.blog.vo.ArticleVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleVo> listArticle(PageParams pageParams) {

        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> qw = new LambdaQueryWrapper<>();
        qw.orderByDesc(Article::getWeight).orderByDesc(Article::getCreateDate);
        Page<Article> page1 = articleMapper.selectPage(page, qw);
        List<Article> articleList = page1.getRecords();
        List<ArticleVo> articleVoList = copyList(articleList, true, true);
        return articleVoList;
    }

    public List<ArticleVo> copyList(List<Article> articleList, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for(Article article : articleList){
            articleVoList.add(copy(article, isTag, isAuthor));
        }
        return articleVoList;
    }

    @Autowired
    private TagService tagService;

    @Autowired
    private SysUserService sysUserService;

    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);

        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));

        if(isTag){
            Long id = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(id));
        }
        if(isAuthor){
            Long authorId = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }

        return articleVo;
    }

    @Override
    public Result hotArticle(int limit) {
        LambdaQueryWrapper<Article> qw = new LambdaQueryWrapper<>();
        qw.orderByDesc(Article::getViewCounts);
        qw.select(Article::getId, Article::getTitle);
        qw.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(qw);
        List<ArticleVo> articleVoList = copyList(articles, false, false);
        return Result.success(articleVoList);
    }

    @Override
    public Result newArticle(int limit) {
        LambdaQueryWrapper<Article> qw =  new LambdaQueryWrapper<>();
        qw.orderByDesc(Article::getCreateDate);
        qw.select(Article::getId, Article::getTitle);
        qw.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(qw);
        return Result.success(copyList(articles, false, false));
    }

    @Override
    public Result listArchives() {
        List<Archives> archivesList =  articleMapper.listArchives();
        return Result.success(archivesList);
    }
}
