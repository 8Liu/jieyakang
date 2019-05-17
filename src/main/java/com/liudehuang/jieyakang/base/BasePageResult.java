package com.liudehuang.jieyakang.base;

import lombok.Data;

import java.util.List;

/**
 * @author liudehuang
 * @date 2019/5/15 10:30
 */
@Data
public class BasePageResult {
    /**
     * 结果集
     */
    private List result;
    /**
     * 总数
     */
    private Integer total;
}
