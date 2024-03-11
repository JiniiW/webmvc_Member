package com.webmvc.controller;

import com.webmvc.dto.MemberDTO;
import com.webmvc.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("login get()");
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("login post()");
        String memberId = request.getParameter("id");
        String memberPassword = request.getParameter("password");

        try {
            MemberDTO memberDTO = memberService.login(memberId, memberPassword);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("loginInfo", memberDTO);
            response.sendRedirect("/member/all");

        } catch (Exception e) {
            log.error(e);
            response.sendRedirect("/login?result=error");
        }

    }
}
