package com.amolrang.modume.model;

import java.util.Collection;

import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomUser extends User{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	//추가정보 입력 시작
	private String user_name;
	private String user_email;
	//추가정보 입력 끝
	
	public CustomUser(String username, String password
            , boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked
            , Collection authorities
            , String user_email, String user_name) {
        super(username, password
                , enabled, accountNonExpired, credentialsNonExpired, accountNonLocked
                , authorities);
        this.user_email = user_email;
        this.user_name = user_name;
    }
}
