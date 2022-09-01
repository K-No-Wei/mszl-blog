package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 查找文章作者
     * @param id
     * @return
     */
    SysUser findUserById(Long id);
}
