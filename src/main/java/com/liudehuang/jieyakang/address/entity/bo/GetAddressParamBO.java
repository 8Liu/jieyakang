package com.liudehuang.jieyakang.address.entity.bo;

import com.liudehuang.jieyakang.base.BasePageParam;
import lombok.Data;

/**
 * @author liudehuang
 * @date 2019/5/15 10:22
 *  获取地址信息查询参数
 */
@Data
public class GetAddressParamBO extends BasePageParam {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 联系人
     */
    private String linkMan;
    /**
     * 是否为默认
     */
    private Integer isDefault;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
}
