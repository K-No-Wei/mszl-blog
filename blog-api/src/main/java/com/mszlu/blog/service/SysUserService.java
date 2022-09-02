package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
public interface SysUserService  {

    /**
     * 查找文章作者
     * @param id
     * @return
     */
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    Result getUserInfoByToken(String token);

    /**
     * 工具账户查找账号
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);

    /**
     * 保存用户
     * @param sysUser
     */
    void save(SysUser sysUser);

    /**
     * 查找信息
     * @param authorId
     * @return
     */
    UserVo findUserVoById(Long authorId);

}
