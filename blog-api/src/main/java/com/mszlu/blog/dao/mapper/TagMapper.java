package com.mszlu.blog.dao.mapper;

import com.mszlu.blog.dao.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(Long id);

    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> hotsTagIdS);
}
