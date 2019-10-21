package com.zhetiwohui.www.controller;

import com.zhetiwohui.www.dao.userinfoDao;
import com.zhetiwohui.www.entity.userEntity;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowInfoController",urlPatterns = "/show")
public class ShowInfoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        userinfoDao sd = new userinfoDao();
        userEntity s = sd.queryByID(username);
        //如果能查到用户信息
        if (s != null) {
            response.setHeader("username",s.getUsername());
            response.setHeader("gender", s.getGender());
            response.setHeader("tel", s.getTel());
            response.setHeader("email", s.getEmailAddress());
            response.setIntHeader("balance", s.getBalance());
        }
        else {
            response.setStatus(401);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
