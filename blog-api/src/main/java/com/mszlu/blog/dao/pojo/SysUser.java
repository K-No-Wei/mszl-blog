package com.mszlu.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcc
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ms_sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 是否管理员
     */
    @TableField("admin")
    private Boolean admin;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 注册时间
     */
    @TableField("create_date")
    private Long createDate;

    /**
     * 是否删除
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 最后登录时间
     */
    @TableField("last_login")
    private Long lastLogin;

    /**
     * 手机号
     */
    @TableField("mobile_phone_number")
    private String mobilePhoneNumber;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 加密盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 状态
     */
    @TableField("status")
    private String status;


}
