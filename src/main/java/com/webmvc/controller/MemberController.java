package com.webmvc.controller;

import com.webmvc.dto.MemberDTO;
import com.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
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
        } else if ("/update".equals(pathInfo)) {

        } else if ("/delete".equals(pathInfo)) {

        } else if ("/add".equals(pathInfo)) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
}
