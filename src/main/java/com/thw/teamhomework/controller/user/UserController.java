package com.thw.teamhomework.controller.user;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
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



@WebServlet(name = "UserController", urlPatterns = {"/api/register"})
public class UserController extends HttpServlet {

    ApiResult result = new ApiResult();
    UsersDAO dao = new UsersDAO();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String reqUserId = request.getParameter("userId");
        String pageNum = request.getParameter("pageNum");
        System.out.println("reqUserId = " + reqUserId);
        System.out.println("pageNum = " + pageNum);
        if(pageNum != null){
            if(Integer.parseInt(pageNum) == 1){
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
                response.setContentType("application/json; charset=UTF-8");

                System.out.println("post");
                PrintWriter out = response.getWriter();
                out.print(result);
                out.flush();
            }
            if(Integer.parseInt(pageNum) == 2){
                String userId = request.getParameter("userId");
                System.out.println("userId = " + userId);
                User dto = new User();
                dao.SELECT_USER(Long.parseLong(userId));
                response.setContentType("application/json;  charset=UTF-8");
                try{
                    Gson gson = new Gson();
                    String json = gson.toJson(dto);
                    PrintWriter out = response.getWriter();
                    out.print(json);
                    out.flush();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            Gson gson = new Gson();
            result.setCode("202");
            String json = gson.toJson(result);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        }
    }
}
