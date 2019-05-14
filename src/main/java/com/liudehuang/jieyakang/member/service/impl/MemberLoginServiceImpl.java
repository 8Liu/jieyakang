package com.liudehuang.jieyakang.member.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.alibaba.fastjson.JSONObject;
import com.liudehuang.jieyakang.base.BaseApiService;
import com.liudehuang.jieyakang.base.BaseRedisService;
import com.liudehuang.jieyakang.base.BaseResponse;
import com.liudehuang.jieyakang.config.WxMaConfiguration;
import com.liudehuang.jieyakang.constants.Constants;
import com.liudehuang.jieyakang.member.dao.MemberLoginDao;
import com.liudehuang.jieyakang.member.entity.bo.MemberLoginBO;
import com.liudehuang.jieyakang.member.entity.dto.UserInfoDTO;
import com.liudehuang.jieyakang.member.service.MemberLoginService;
import com.liudehuang.jieyakang.utils.CookieUtils;
import com.liudehuang.jieyakang.utils.GenerateToken;
import com.liudehuang.jieyakang.utils.MeiteBeanUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liudehuang
 * @date 2019/5/14 9:56
 */
@Slf4j
@Service
public class MemberLoginServiceImpl extends BaseApiService implements MemberLoginService {
    @Autowired
    private BaseRedisService baseRedisService;
    @Autowired
    private MemberLoginDao memberLoginDao;
    @Autowired
    private GenerateToken generateToken;

    @Override
    public BaseResponse<JSONObject> login(MemberLoginBO param, String appid, HttpServletRequest request, HttpServletResponse response) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(param.getCode());
            log.info("openid:{},sessionKey:{}",session.getOpenid(),session.getSessionKey());
            // 用户信息校验
            if (!wxService.getUserService().checkUserInfo(session.getSessionKey(), param.getRawData(), param.getSignature())) {
                return setResultError("user check failed");
            }
            // 解密用户信息
            WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), param.getEncryptedData(), param.getIv());
            log.info("用户信息userinfo:{}", JSONObject.toJSONString(userInfo));
            UserInfoDTO user = memberLoginDao.getUserInfo(userInfo.getOpenId());
            if(user==null){
                UserInfoDTO userInfoDTO = MeiteBeanUtils.t2s(userInfo, UserInfoDTO.class);
                int result = memberLoginDao.registerMember(userInfoDTO);
                if(!toDaoResult(result)){
                    return setResultError("用户注册失败");
                }
            }
            //生成token，存入redis中
            String token = generateToken.createToken(Constants.JIEYAKANG_TOKEN_MEMBER, userInfo.getOpenId(), Constants.MEMBRE_LOGIN_TOKEN_TIME);
            CookieUtils.setCookie(request, response, Constants.JIEYAKANG_COOKIE_MEMBER_TOKEN, token);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token",token);
            return setResultSuccess(jsonObject);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
            return setResultError("系统错误");
        }

    }

    @Override
    public BaseResponse getUserInfo(String token) {
        String openId = baseRedisService.getString(token);
        if(StringUtils.isEmpty(openId)){
            return setResultError("token失效或者已过期");
        }
        UserInfoDTO userInfo = memberLoginDao.getUserInfo(openId);
        if(userInfo==null){
            return setResultError("用户信息不存在");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userInfo",userInfo);
        return setResultSuccess(jsonObject);
    }
}
