package com.thw.teamhomework.DAO;

import com.thw.system.DB.DBClose;
import com.thw.system.DB.DBConnection;
import com.thw.teamhomework.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsersDAO {
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;
    private String USER_SELECT ="SELECT * FROM Users WHERE userId = 1";

    private String USER_INSERT ="INSERT INTO Users" +
            "(userId, password, name, birth, address, majorId, role, status) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    public void SELECT_USER(User dto){
        try{
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(USER_SELECT);
            rs = psmt.executeQuery();
            while (rs.next()){
                dto.setUserId(rs.getLong("userId"));
                dto.setPassword(rs.getString("password"));
                dto.setName(rs.getString("name"));
                dto.setBirth(rs.getDate("birth"));
                dto.setAddress(rs.getString("address"));
                dto.setMajorId(rs.getLong("majorId"));
                dto.setRole(rs.getString("role"));
                dto.setStatus(rs.getString("status"));
                System.out.println(dto);
            }

        } catch (NullPointerException e2){
            System.out.println("Null");
            e2.printStackTrace();
        } catch (Exception e){
            System.out.println("dwadwa");
            e.printStackTrace();
        } finally {
            DBClose.close(rs, psmt, conn);
        }
    }

    public void INSERT_USER(User dto){
        Connection con = null;
        try{
            con = DBConnection.getConnection();
            psmt = con.prepareStatement(USER_INSERT);

            System.out.println(dto.getUserId());
            System.out.println(dto.getPassword());

            psmt.setLong(1, dto.getUserId());
            psmt.setString(2, dto.getPassword().trim());
            psmt.setString(3, dto.getName().trim());
            psmt.setDate(4, dto.getBirth());
            psmt.setString(5, dto.getAddress().trim());
            psmt.setLong(6, dto.getMajorId());
            psmt.setString(7, dto.getRole());
            psmt.setString(8, dto.getStatus());

            int i = psmt.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            System.out.println("dwadwa");
            e.printStackTrace();
        }finally {
            DBClose.close(rs, psmt,conn);
        }

    }

}
