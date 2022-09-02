package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.CommentParam;

public interface CommentsService {
    /**
     * 获取文章评论信息
     * @param articleId
     * @return
     */
    Result commentsByArticleId(Long articleId);

    /**
     * 提交评论
     * @param commentParam
     * @return
     */
    Result comment(CommentParam commentParam);
}
