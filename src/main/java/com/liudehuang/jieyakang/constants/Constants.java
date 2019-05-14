package com.liudehuang.jieyakang.constants;

public interface Constants {
	/**
	 * 响应请求成功
 	 */
	String HTTP_RES_CODE_200_VALUE = "success";
	/** 系统错误
	 *
	 */
	String HTTP_RES_CODE_500_VALUE = "fial";
	/**响应请求成功code
	 *
	 */
	Integer HTTP_RES_CODE_200 = 200;
	/**
	 *	用户信息不存在
	 */
	Integer HTTP_RES_CODE_EXISTMOBILE_203 = 203;
	/** 系统错误
	 *
	 */
	Integer HTTP_RES_CODE_500 = 500;
	/** 未关联QQ账号
	 *
	 */
	Integer HTTP_RES_CODE_201 = 201;
	/** 发送邮件
	 *
	 */
	String MSG_EMAIL = "email";
	/**
	 * 洁雅康token
	 */
	String JIEYAKANG_TOKEN_MEMBER = "JIEYAKANG_TOKEN_MEMBER";

	/**
	 * 登陆超时时间 有效期 90天
	 */
	Long MEMBRE_LOGIN_TOKEN_TIME = 77776000L;

	/**
	 * cookie有效期
	 */
	int JIEYAKANG_COOKIE_MEMBER_TOKEN_TIMEOUT = (60 * 60 * 24 * 90);
	/**
	 * cookie 会员 totoken 名称
	 */
	String JIEYAKANG_COOKIE_MEMBER_TOKEN = "cookie_jiyakang_member_token";
	/**
	 * 微信注册码存入redis中的前缀
	 */
	String WEIXINCODE_KEY = "weixin.code";
	/**
	 * 微信注册码有效期30分钟
	 */
	Long WEIXINCODE_TIMEOUT = 1800L;




	// 用户信息不存在
	Integer HTTP_RES_CODE_NOTUSER_203 = 203;




}