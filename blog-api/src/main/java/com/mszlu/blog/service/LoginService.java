package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.LoginParam;

public interface LoginService {
    /**
     * 登入功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    /**
     * 检查token
     * @param token
     * @return
     */
    SysUser checkToken(String token);

    /**
     * 推出登入
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册账号
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
