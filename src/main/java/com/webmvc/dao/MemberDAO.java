package com.webmvc.dao;

import com.webmvc.domain.MemberVO;
import com.webmvc.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class MemberDAO {

    // 목록 조회
    public List<MemberVO> listMembers() {
        String sql = "SELECT * FROM mvc_member";

        List<MemberVO> voList = new ArrayList<>();

        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
            @Cleanup ResultSet rs = pstmt.executeQuery();

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
        } catch (Exception e) {
            log.error(e);
        }
        return voList;
    }

    // 회원 추가
    public int addMember(MemberVO memberVO) {

        int ack = 0;

        String sql = "INSERT INTO mvc_member VALUES (?, ?, ?, ?, now())";

        try {
            @Cleanup Connection coon = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = coon.prepareStatement(sql);

            pstmt.setString(1, memberVO.getId());
            pstmt.setString(2, memberVO.getPassword());
            pstmt.setString(3, memberVO.getName());
            pstmt.setString(4, memberVO.getEmail());

            ack = pstmt.executeUpdate();
        } catch (Exception e) {
            log.error(e);
        }
        return ack;
    }

    // 회원 수정

    public MemberVO getMemberById(String id) {
        String sql = "SELECT * FROM mvc_member WHERE id = ?";

        MemberVO memberVO = null;

        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, id);

            @Cleanup ResultSet rs = pstmt.executeQuery();

            rs.next();

            memberVO = MemberVO.builder()
                    .id(rs.getString("id"))
                    .password(rs.getString("password"))
                    .email(rs.getString("email"))
                    .name(rs.getString("name"))
                    .build();
        } catch (Exception e) {
            log.error(e);
        }
        return memberVO;

    }

    public int updateMember(MemberVO memberVO) {
        int ack = 0;

        String sql = "UPDATE mvc_member SET password = ?, name = ?, email = ? WHERE id = ?";

        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, memberVO.getPassword());
            pstmt.setString(2, memberVO.getName());
            pstmt.setString(3, memberVO.getEmail());
            pstmt.setString(4, memberVO.getId());

            ack = pstmt.executeUpdate();

        } catch (Exception e) {
            log.error(e);
        }
        return ack;
    }

    // 회원 삭제
    public int deleteMember(String id) {
        int ack = 0;
        String sql = "DELETE FROM mvc_member WHERE id = ?";

        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, id);

            ack = pstmt.executeUpdate();
        } catch (Exception e) {
            log.error(e);
        }
        return ack;
    }

    //로그인
    public MemberVO getWithPassword(String memberId, String memberPassword) {
        String sql = "SELECT id, password, name FROM mvc_member WHERE id = ? AND password = ?";

        MemberVO memberVO;

        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, memberId);
            pstmt.setString(2, memberPassword);

            @Cleanup ResultSet rs = pstmt.executeQuery();

            rs.next();

            memberVO = MemberVO.builder()
                    .id(rs.getString(1))
                    .password(rs.getString(2))
                    .name(rs.getString(3))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return memberVO;
    }
}
