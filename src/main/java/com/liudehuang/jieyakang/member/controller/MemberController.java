package com.liudehuang.jieyakang.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.liudehuang.jieyakang.base.BaseApiService;
import com.liudehuang.jieyakang.base.BaseResponse;
import com.liudehuang.jieyakang.member.entity.bo.GetUserListBO;
import com.liudehuang.jieyakang.member.entity.bo.MemberLoginBO;
import com.liudehuang.jieyakang.member.service.MemberLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author liudehuang
 * @date 2019/5/14 9:24
 */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController extends BaseApiService {
    @Autowired
    private MemberLoginService memberLoginService;


    @PostMapping("/{appid}/login")
    public BaseResponse<JSONObject> login(@PathVariable String appid, @Valid MemberLoginBO param, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){
        //1、接收表单参数，创建接受对象
        if(bindingResult.hasErrors()) {
            //如果参数验证错误
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            log.info("验证参数出错:{}",errorMsg);
            return setResultError(errorMsg);
        }
        return memberLoginService.login(param,appid,request,response);
    }

    @GetMapping("/getUserInfo")
    public BaseResponse getUserInfo(@RequestParam("token") String token){
        log.info("token:{}",token);
        if(StringUtils.isEmpty(token)){
            return setResultError("token不能为空");
        }
        return memberLoginService.getUserInfo(token);
    }

    @PostMapping("/getUserList")
    public BaseResponse getUserList(@Validated GetUserListBO param, BindingResult bindingResult){
        log.info("param:{}",param);
        //1、接收表单参数，创建接受对象
        if(bindingResult.hasErrors()) {
            //如果参数验证错误
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            log.info("验证参数出错:{}",errorMsg);
            return setResultError(errorMsg);
        }
        return memberLoginService.getUserList(param);
    }
}
