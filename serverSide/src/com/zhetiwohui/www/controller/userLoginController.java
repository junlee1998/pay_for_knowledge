package com.zhetiwohui.www.controller;

import com.zhetiwohui.www.dao.userinfoDao;
import com.zhetiwohui.www.entity.userEntity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userLoginController", urlPatterns = "/login")
public class userLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        userinfoDao sd = new userinfoDao();
        userEntity s = sd.queryByID(username, password);
        System.out.println(s);
        if (s == null) {
            response.setStatus(401);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get");

        // 设置request的字符编码utf-8,解决前端页面传递中文数据乱码问题，要和html页面编码方式统一
        request.setCharacterEncoding("utf-8");
        // 通过request对象的getParameter方法获取前端请求的表单数据，返回值为字符串
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
//        String gender = "1";
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String transaction_password = request.getParameter("transaction_password");


        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("gender:" + gender);
        System.out.println("tel:" + tel);
        System.out.println("email:" + email);
        System.out.println("transaction_password:" + transaction_password);

        userEntity userinfo = new userEntity(username, password, gender, tel, email, transaction_password);
        userinfoDao sd = new userinfoDao();
        boolean result =  sd.insert(userinfo);
        if (!result){
            response.sendRedirect("http://localhost:8080/#/register");
        }else {
            response.sendRedirect("http://localhost:8080/#/login");
        }
    }
}