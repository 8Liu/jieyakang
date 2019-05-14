package com.liudehuang.jieyakang.member.dao;

import com.liudehuang.jieyakang.member.entity.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author liudehuang
 * @date 2019/5/14 9:50
 */
@Repository
public interface MemberLoginDao {
    /**
     * 用户注册接口
     * @param param
     * @return
     */
    int registerMember(UserInfoDTO param);

    /**
     * 根据openId获取用户信息
     * @param openId
     * @return
     */
    UserInfoDTO getUserInfo(@Param("openId") String openId);
}
