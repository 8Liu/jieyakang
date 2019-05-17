package com.liudehuang.jieyakang.address.service;

import com.liudehuang.jieyakang.address.entity.bo.AddressBO;
import com.liudehuang.jieyakang.address.entity.bo.GetAddressParamBO;
import com.liudehuang.jieyakang.base.BaseResponse;

/**
 * @author liudehuang
 * @date 2019/5/15 10:05
 */
public interface AddressService {
    /**
     * 添加收货地址
     * @param param
     * @return
     */
    BaseResponse addAddress(AddressBO param);

    /**
     * 根据参数获取收货地址
     * @param param
     * @return
     */
    BaseResponse getAddress(GetAddressParamBO param);

    /**
     * 根据token获取个人的收货地址信息
     * @param token
     * @return
     */
    BaseResponse getAddressByToken(String token);
}
