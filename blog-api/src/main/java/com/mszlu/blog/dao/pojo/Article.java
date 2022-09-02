package com.mszlu.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("ms_article")
public class Article implements Serializable {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论数量
     */
    @TableField("comment_counts")
    private int commentCounts;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private Long createDate;

    /**
     * 简介
     */
    @TableField("summary")
    private String summary;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 浏览数量
     */
    @TableField("view_counts")
    private int viewCounts;

    /**
     * 是否置顶
     */
    @TableField("weight")
    private int weight = Article_Common;

    /**
     * 作者id
     */
    @TableField("author_id")
    private Long authorId;

    /**
     * 内容id
     */
    @TableField("body_id")
    private Long bodyId;

    /**
     * 类别id
     */
    @TableField("category_id")
    private Long categoryId;


}
