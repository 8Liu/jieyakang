package com.liudehuang.jieyakang.address.entity.dto;

import lombok.Data;

/**
 * @author liudehuang
 * @date 2019/5/15 9:55
 */
@Data
public class AddressDTO {
    /**
     * 收货地址uuid
     */
    private String id;
    /**
     * 微信开放id
     */
    private String openId;
    /**
     * 是否为默认地址0：默认 1：不是默认
     */
    private Integer isDefault;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系人
     */
    private String linkMan;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 备注
     */
    private String remark;
}
