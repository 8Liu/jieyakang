package com.liudehuang.jieyakang.address.controller;

import com.liudehuang.jieyakang.address.entity.bo.AddressBO;
import com.liudehuang.jieyakang.address.entity.bo.GetAddressParamBO;
import com.liudehuang.jieyakang.address.service.AddressService;
import com.liudehuang.jieyakang.base.BaseApiService;
import com.liudehuang.jieyakang.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liudehuang
 * @date 2019/5/15 10:02
 */
@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController extends BaseApiService {
    @Autowired
    private AddressService addressService;
    /**
     * 添加收货地址
     * @return
     */
    @PostMapping("/addAddress")
    public BaseResponse addAddress(@Validated AddressBO param, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            //如果参数验证错误
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            log.info("验证参数出错:{}",errorMsg);
            return setResultError(errorMsg);
        }
        return addressService.addAddress(param);
    }

    /**
     * 获取所有用户的地址信息
     * @param param
     * @return
     */
    @PostMapping("/getAddress")
    public BaseResponse getAddress(@Validated GetAddressParamBO param,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            //如果参数验证错误
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            log.info("验证参数出错:{}",errorMsg);
            return setResultError(errorMsg);
        }
        return addressService.getAddress(param);
    }

    /**
     *根据token获取当前个人的地址信息
     * @param token
     * @return
     */
    @RequestMapping("/getAddressByToken")
    public BaseResponse getAddressByToken(@RequestParam("token") String token){
        if(StringUtils.isEmpty(token)){
            return setResultError("token不能为空");
        }
        return addressService.getAddressByToken(token);
    }
}
