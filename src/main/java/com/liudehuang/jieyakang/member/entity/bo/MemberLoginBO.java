package com.liudehuang.jieyakang.member.entity.bo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author liudehuang
 * @date 2019/5/14 9:39
 */
@Data
public class MemberLoginBO {
    /**
     * code码（前端通过wx.login获取的）
     */
    @NotEmpty
    private String code;
    /**
     * 签名（前端通过wx.getUserInfo获取的）
     */
    @NotEmpty
    private String signature;
    /**
     * 原数据（前端通过wx.getUserInfo获取的）
     */
    @NotEmpty
    private String rawData;
    /**
     * 加密数据（前端通过wx.getUserInfo获取的）
     */
    @NotEmpty
    private String encryptedData;
    /**
     * 加密算法的初始向量
     */
    @NotEmpty
    private String iv;

}
