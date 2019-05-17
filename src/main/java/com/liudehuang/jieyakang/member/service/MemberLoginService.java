package com.liudehuang.jieyakang.member.service;

import com.alibaba.fastjson.JSONObject;
import com.liudehuang.jieyakang.base.BaseResponse;
import com.liudehuang.jieyakang.member.entity.bo.GetUserListBO;
import com.liudehuang.jieyakang.member.entity.bo.MemberLoginBO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liudehuang
 * @date 2019/5/14 9:50
 */
public interface MemberLoginService {
    /**
     * 登录请求
     * @param param
     * @return
     */
    BaseResponse<JSONObject> login(MemberLoginBO param, String appid, HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    BaseResponse<JSONObject> getUserInfo(String token);

    /**
     *
     * @param param
     * @return
     */
    BaseResponse getUserList(GetUserListBO param);
}
