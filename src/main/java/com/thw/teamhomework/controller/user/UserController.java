package com.thw.teamhomework.controller.user;
import com.thw.teamhomework.entity.User;
import com.thw.teamhomework.DAO.UsersDAO;
import com.thw.teamhomework.DTO.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "UserController", urlPatterns = {"/api/register"})
public class UserController extends HttpServlet {

    ApiResult result = new ApiResult();
    UsersDAO dao = new UsersDAO();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userId =request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String majorId = request.getParameter("majorId");
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        User dto = new User();

        dto.setUserId(Long.parseLong(userId));
        dto.setPassword(password);
        dto.setName(name);
        dto.setBirth(Date.valueOf(birth));
        dto.setAddress(address);
        dto.setMajorId(Long.parseLong(majorId));
        dto.setRole(role);
        dto.setStatus(status);


        dao.INSERT_USER(dto);
        result.setCode("200");
        response.setContentType("application/jason");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User dto = new User();
        dao.SELECT_USER(dto);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dto);

        response.setContentType("application/jason;  charset=UTF-8");
        result.setCode("200");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.print(result.getCode());
        out.flush();
    }

}
