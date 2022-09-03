package com.mszlu.blog.controller;


import com.mszlu.blog.service.TagService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 文章最热标签
     * @return
     */
    @GetMapping("/hot")
    public Result listHotTags(){
        int limit = 6;
        List<TagVo> tagVoList = tagService.hot(limit);
        return Result.success(tagVoList);
    }

    @GetMapping()
    public Result findAll(){
        return tagService.findAll();
    }

    @GetMapping("detail")
    public Result findAllDetail(){
        return tagService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public Result findDetailById(@PathVariable("id") Long id){
        return tagService.findDetailById(id);
    }
}
