package com.amolrang.modume.mapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private String id;
    private String user_email;
    private String user_name;
    private String user_status;
    private String auth_site;
    private String user_password;
    private String user_role;
}