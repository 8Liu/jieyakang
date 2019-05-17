package com.liudehuang.jieyakang.address.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.liudehuang.jieyakang.address.dao.AddressDao;
import com.liudehuang.jieyakang.address.entity.bo.AddressBO;
import com.liudehuang.jieyakang.address.entity.bo.GetAddressParamBO;
import com.liudehuang.jieyakang.address.entity.dto.AddressDTO;
import com.liudehuang.jieyakang.address.entity.po.AddressPO;
import com.liudehuang.jieyakang.address.service.AddressService;
import com.liudehuang.jieyakang.base.BaseApiService;
import com.liudehuang.jieyakang.base.BasePageResult;
import com.liudehuang.jieyakang.base.BaseRedisService;
import com.liudehuang.jieyakang.base.BaseResponse;
import com.liudehuang.jieyakang.member.dao.MemberDao;
import com.liudehuang.jieyakang.member.entity.dto.UserInfoDTO;
import com.liudehuang.jieyakang.member.entity.po.UserInfoPO;
import com.liudehuang.jieyakang.utils.GenerateId;
import com.liudehuang.jieyakang.utils.MeiteBeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liudehuang
 * @date 2019/5/15 10:05
 */
@Service
public class AddressServiceImpl extends BaseApiService implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private BaseRedisService baseRedisService;

    @Override
    public BaseResponse addAddress(AddressBO param) {
        String token = param.getToken();
        BaseResponse response = getOpenIdByToken(token);
        JSONObject jsonObject = (JSONObject) response.getData();
        String openId = jsonObject.getString("openId");
        AddressDTO addressDTO = MeiteBeanUtils.t2s(param, AddressDTO.class);
        addressDTO.setId(GenerateId.createGenerateId());
        addressDTO.setOpenId(openId);
        int row = addressDao.addAddress(addressDTO);
        if(!toDaoResult(row)){
            return setResultError("添加收货地址失败");
        }
        return setResultSuccess("添加收货地址成功");
    }

    @Override
    public BaseResponse getAddress(GetAddressParamBO param) {
        List<AddressPO> addressList = addressDao.getAddress(param);
        int total = addressDao.countAddress(param);
        BasePageResult result = new BasePageResult();
        result.setResult(addressList);
        result.setTotal(total);
        return setResultSuccess(result);
    }

    @Override
    public BaseResponse getAddressByToken(String token) {
        BaseResponse response = getOpenIdByToken(token);
        JSONObject jsonObject = (JSONObject) response.getData();
        String openId = jsonObject.getString("openId");
        List<AddressPO> addressList = addressDao.getAddressByOpneId(openId);
        return setResultSuccess(addressList);
    }


    public BaseResponse getOpenIdByToken(String token){
        String openId = baseRedisService.getString(token);
        if(StringUtils.isEmpty(openId)){
            return setResultError("token已过期或已失效");
        }
        UserInfoPO userInfo = memberDao.getUserInfo(openId);
        if(userInfo==null){
            return setResultError("用户信息不存在");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openId",openId);
        return setResultSuccess(jsonObject);
    }
}
