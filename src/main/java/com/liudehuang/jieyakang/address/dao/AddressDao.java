package com.liudehuang.jieyakang.address.dao;

import com.liudehuang.jieyakang.address.entity.bo.AddressBO;
import com.liudehuang.jieyakang.address.entity.bo.GetAddressParamBO;
import com.liudehuang.jieyakang.address.entity.dto.AddressDTO;
import com.liudehuang.jieyakang.address.entity.po.AddressPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liudehuang
 * @date 2019/5/15 10:06
 */
@Repository
public interface AddressDao {
    /**
     * 添加收货地址
     * @param param
     * @return
     */
    int addAddress(AddressDTO param);

    /**
     * 根据查询参数查询
     * @param param
     * @return
     */
    List<AddressPO> getAddress(GetAddressParamBO param);

    /**
     * 查询条数
     * @param param
     * @return
     */
    int countAddress(GetAddressParamBO param);

    /**
     * 根据客户信息获取客户的收货地址
     * @param openId
     * @return
     */
    List<AddressPO> getAddressByOpneId(@Param("openId") String openId);

}
