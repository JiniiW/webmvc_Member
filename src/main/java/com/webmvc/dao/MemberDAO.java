package com.webmvc.dao;

import com.webmvc.domain.MemberVO;
import com.webmvc.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    // 목록 조회
    public List<MemberVO> listMembers() throws Exception {
        String sql = "SELECT * FROM mvc_member";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<MemberVO> voList = new ArrayList<>();

        while (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .id(rs.getString("id"))
                    .password(rs.getString("password"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .joinDate(rs.getDate("join_Date").toLocalDate())
                    .build();

            voList.add(vo);
        }
        return voList;
    }

    // 회원 추가
    public void addMember(){}

    // 회원 수정
    public void updateMember(){}

    // 회원 삭제
    public void deleteMember(){}
}
