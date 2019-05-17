package com.liudehuang.jieyakang.utils;

import java.util.UUID;

/**
 * @author liudehuang
 * @date 2019/5/15 11:23
 */
public class GenerateId {

    public static String createGenerateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
