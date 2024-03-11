package com.webmvc.dao;

import com.webmvc.domain.MemberVO;
import com.webmvc.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
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
    public int addMember(MemberVO memberVO) throws Exception {

        int ack = 0;

        String sql = "INSERT INTO mvc_member VALUES (?, ?, ?, ?, now())";

        @Cleanup Connection coon = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = coon.prepareStatement(sql);

        pstmt.setString(1, memberVO.getId());
        pstmt.setString(2, memberVO.getPassword());
        pstmt.setString(3, memberVO.getName());
        pstmt.setString(4, memberVO.getEmail());

        ack = pstmt.executeUpdate();

        return ack;
    }

    // 회원 수정

    public MemberVO getMemberById(String id) throws Exception {
        String sql = "SELECT * FROM mvc_member WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        MemberVO memberVO = MemberVO.builder()
                .id(rs.getString("id"))
                .password(rs.getString("password"))
                .email(rs.getString("email"))
                .name(rs.getString("name"))
                .build();

        return memberVO;

    }
    public int updateMember(MemberVO memberVO) throws Exception {
        int ack = 0;

        String sql = "UPDATE mvc_member SET password = ?, name = ?, email = ? WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, memberVO.getPassword());
        pstmt.setString(2, memberVO.getName());
        pstmt.setString(3, memberVO.getEmail());
        pstmt.setString(4, memberVO.getId());

        ack = pstmt.executeUpdate();

        return ack;

    }

    // 회원 삭제
    public int deleteMember(String id) throws Exception {
        int ack = 0;
        String sql = "DELETE FROM mvc_member WHERE id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);

        ack = pstmt.executeUpdate();

        return ack;
    }

    //로그인
    public MemberVO getWithPassword(String memberId, String memberPassword) throws Exception {
        String sql = "SELECT id, password, name FROM mvc_member WHERE id = ? AND password = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, memberId);
        pstmt.setString(2, memberPassword);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        MemberVO memberVO = MemberVO.builder()
                .id(rs.getString(1))
                .password(rs.getString(2))
                .name(rs.getString(3))
                .build();

        return memberVO;
    }
}
