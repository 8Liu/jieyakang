package com.liudehuang.jieyakang.member.entity.bo;

import com.liudehuang.jieyakang.base.BasePageParam;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author liudehuang
 * @date 2019/5/15 14:19
 */
@Data
public class GetUserListBO extends BasePageParam {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;



}
