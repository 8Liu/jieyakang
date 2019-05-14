package com.liudehuang.jieyakang.member.entity.dto;

import lombok.Data;

/**
 * @author liudehuang
 * @date 2019/5/14 10:07
 */
@Data
public class UserInfoDTO {
    /**
     * 微信开放id
     */
    private String openId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 语言
     */
    private String language;
    /**
     * 城市
     */
    private String city;
    /**
     * 省份
     */
    private String province;
    /**
     * 国家
     */
    private String country;
    /**
     *
     */
    private String avatarUrl;
    /**
     *
     */
    private String unionId;
    /***
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
}
