package com.amolrang.modume.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.amolrang.modume.mapper.CustomUserMapper;
import com.amolrang.modume.mapper.MemberDTO;
import com.amolrang.modume.model.CustomUser;

public class CustomUserDetailsService implements UserDetailsService {

	/**
	 * 인증 매니저는 인증과 관련된 모든 정보를 UserDetails 라는 타입으로 변환하는데 인증되는 방식을 수정하고 싶을때
	 * UserDetailsService 라는 인터페이스를 구현함으로써 인증매니저에 연결.
	 *
	 * 여기서는 DB에 저장되어 있는 유저정보를 조회하여 UserDetails 을 구성한다.
	 */

	@Autowired
	CustomUserMapper memberMapper;

	// 시큐리티의 내용 외 파라미터를 추가하고 싶을 때, 아래 사용
	// 제약조건: Controller 에서 Auth를 점검할 때, UserCustom 으로 받아야 함.
	// 예) (변경 전) @AuthenticationPrincipal User user => (변경 후)
	// @AuthenticationPrincipal UserCustom user

	boolean enabled = true;
	boolean accountNonExpired = true;
	boolean credentialsNonExpired = true;
	boolean accountNonLocked = true;

	@Override
	public UserDetails loadUserByUsername(String user_email) throws UsernameNotFoundException {
		// 로그인 시도하려는 유저정보 조회
		MemberDTO memberDTO = memberMapper.chkLogin(user_email);

		// 조회가 되지않는 고객은 에러발생.
		if (memberDTO == null) {
			throw new UsernameNotFoundException(user_email);
		}

		CustomUser userCustom = new CustomUser(memberDTO.getUser_email(), memberDTO.getUser_password(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, authorities(memberDTO),
				memberDTO.getUser_email(), memberDTO.getUser_name() // 이름
		);

		return userCustom;
	}

	// DB에 등록된 권한에 따라 유저권한 부여 user_role
	private static Collection<? extends GrantedAuthority> authorities(MemberDTO memberDTO) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList();
		// DB에 저장한 USER_ROLE 이 1이면 ADMIN 권한, 아니면 ROLE_USER 로 준다.
		if (memberDTO.getUser_role().equals("1")) {
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return authorities;
	}
}
