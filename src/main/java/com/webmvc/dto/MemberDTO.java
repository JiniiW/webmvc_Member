package com.webmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDate joinDate;
}
