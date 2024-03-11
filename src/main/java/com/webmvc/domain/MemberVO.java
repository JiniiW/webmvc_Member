package com.webmvc.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDate joinDate;
}
