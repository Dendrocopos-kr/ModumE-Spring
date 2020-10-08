package com.amolrang.modume.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomUserMapper {

	MemberDTO chkLogin(String user_email);

}
