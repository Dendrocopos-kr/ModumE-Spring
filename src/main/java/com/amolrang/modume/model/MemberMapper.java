package com.amolrang.modume.model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberDTO chkLogin(String user_email);

    int insertMember(MemberDTO memberDTO);

    // 로그아웃-토큰삭제
    int deletePersistentLogins(CustomUser customUser);
}