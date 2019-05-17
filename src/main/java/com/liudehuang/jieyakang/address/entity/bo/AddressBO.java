package com.liudehuang.jieyakang.address.entity.bo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author liudehuang
 * @date 2019/5/15 9:49
 */
@Data
public class AddressBO {
    /**
     * 用户token
     */
    @NotEmpty(message = "token不能为空")
    private String token;
    /**
     * 地址
     */
    @NotEmpty(message = "address地址信息不能为空")
    private String address;
    /**
     * 是否为默认地址0：默认 1：不是默认
     */
    @NotNull(message = "isDefault不能为空")
    private Integer isDefault;
    /**
     * 联系人
     */
    @NotEmpty(message = "联系人linkMan不能为空")
    private String linkMan;
    /**
     * 电话
     */
    @NotEmpty(message = "电话号码mobile不能为空")
    private String mobile;
    /**
     * 备注
     */
    private String remark;

}


