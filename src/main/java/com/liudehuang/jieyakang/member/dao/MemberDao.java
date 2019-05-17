package com.liudehuang.jieyakang.member.dao;

import com.liudehuang.jieyakang.member.entity.bo.GetUserListBO;
import com.liudehuang.jieyakang.member.entity.dto.UserInfoDTO;
import com.liudehuang.jieyakang.member.entity.po.UserInfoPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liudehuang
 * @date 2019/5/14 9:50
 */
@Repository
public interface MemberDao {
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
    UserInfoPO getUserInfo(@Param("openId") String openId);

    /**
     * 根据参数获取用户列表
     * @param param
     * @return
     */
    List<UserInfoPO> getUserList(GetUserListBO param);

    /**
     * 获取用户信息条数
     * @param param
     * @return
     */
    int countUserList(GetUserListBO param);


}
