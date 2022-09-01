package com.mszlu.blog.service.impl;

import com.mszlu.blog.dao.pojo.Tag;
import com.mszlu.blog.dao.mapper.TagMapper;
import com.mszlu.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mszlu.blog.vo.TagVo;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tagList =  tagMapper.findTagsByArticleId(id);
        return copyList(tagList);
    }

    private List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVos = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVos.add(copy(tag));
        }
        return tagVos;
    }

    private TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

}