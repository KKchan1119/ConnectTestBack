package com.thw.teamhomework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thw.system.DB.DBClose;
import com.thw.system.DB.DBConnection;
import com.thw.teamhomework.DAO.UsersDAO;
import com.thw.teamhomework.entity.User;

import java.sql.*;

public class DataAccessTest {
    public static void main(String[] args) throws JsonProcessingException {
        UsersDAO dao = new UsersDAO();
        User dto = new User();

        dao.SELECT_USER(dto);
        System.out.println(dto);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dto);
        
    }
}
