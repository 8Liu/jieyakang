package com.liudehuang.jieyakang.address.entity.po;

import lombok.Data;

/**
 * @author liudehuang
 * @date 2019/5/15 9:55
 */
@Data
public class AddressPO {
    /**
     * 地址编号（uuid）
     */
    private String id;
    /**
     * 微信开放id
     */
    private String openId;
    /**
     * 微信昵称
     */
    private String nickName;
    /**
     * 是否为默认地址：0：默认 1：不是默认
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
     * 电话号码
     */
    private String mobile;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否被删除0:未删除 1:已删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
}
