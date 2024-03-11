package com.webmvc.controller;

import com.webmvc.dto.MemberDTO;
import com.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Log4j2
@WebServlet(name = "memberController", urlPatterns = "/member/*")
public class MemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if ("/all".equals(pathInfo)) {
            handleAllMembers(request, response);
        } else if ("/add".equals(pathInfo)) {
            request.getRequestDispatcher("/WEB-INF/member/MemberForm.jsp").forward(request, response);
        } else if ("/update".equals(pathInfo)) {

        } else if ("/delete".equals(pathInfo)) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if ("/add".equals(pathInfo)) {
            handlePostAddMember(request, response);
        } else if ("/update".equals(pathInfo)) {

        } else if ("/delete".equals(pathInfo)) {

        }
    }

    //메서드 작성
    private void handleAllMembers(HttpServletRequest request, HttpServletResponse response) {
        log.info("controller : getAllMembers()");
        try {
            List<MemberDTO> dtoList = memberService.getAllMembersInfo();
            request.setAttribute("dtoList", dtoList);
            request.getRequestDispatcher("/WEB-INF/member/ListMembers.jsp").forward(request, response);
        } catch (Exception e) {
            log.info(e);
            e.printStackTrace();
        }
    }

    private void handlePostAddMember(HttpServletRequest request, HttpServletResponse response) {
        log.info("controller : handleAddMember()");
        MemberDTO memberDTO = MemberDTO.builder()
                .id(request.getParameter("id"))
                .password(request.getParameter("password"))
                .name(request.getParameter("name"))
                .email(request.getParameter("email"))
                .build();

        try {
            int ack = memberService.addMember(memberDTO);

            if(ack == 1){
                response.sendRedirect("/member/all");
            } else {
                log.info("회원 추가에 실패했습니다.");
                response.sendRedirect("/member/add");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
