package com.zhetiwohui.www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zhetiwohui.www.entity.userEntity;


public class userinfoDao {


    String url = "jdbc:mysql://localhost:3306/pay-for-knowledge?serverTimezone=UTC";
    String username = "root";
    String password = "password";

    public boolean insert(userEntity s) {
        Connection conn = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(url, username, password);
                System.out.println(conn);
                String sql = "insert into userinfo values (?,?,?,?,?,?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, s.getUsername());
                ps.setString(2, s.getPassword());
                ps.setString(3, s.getGender());
                ps.setString(4, s.getTel());
                ps.setString(5, s.getEmailAddress());
                ps.setString(6, s.getTransactionPassword());
                ps.setString(7, s.getHealth());
                ps.setInt(8, s.getBalance());

                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(conn);


        }
    }

    public userEntity queryByID(String username, String password) {
        userEntity s = null;
        Connection conn = DBUtil.getConnection();
        String sql = "select * from userinfo where username=? and password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String get_username = rs.getString(1);
                String get_password = rs.getString(2);
                String gender = rs.getString(3);
                String tel = rs.getString(4);
                String emailAddress = rs.getString(5);
                String transactionPassword = rs.getString(6);
                String health = rs.getString(7);
                int balance = rs.getInt(8);

                s = new userEntity(get_username, get_password, gender, tel, emailAddress, transactionPassword, health, balance);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return s;
    }


    public ArrayList<userEntity> queryAll() {
        ArrayList<userEntity> users = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "select * from userinfo";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String get_username = rs.getString(1);
                String password = rs.getString(2);
                String gender = rs.getString(3);
                String tel = rs.getString(4);
                String emailAddress = rs.getString(5);
                String transactionPassword = rs.getString(6);
                String health = rs.getString(7);
                int balance = rs.getInt(8);

                userEntity s = new userEntity(get_username, password, gender, tel, emailAddress, transactionPassword, health, balance);

                users.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return users;
    }


    public boolean delete(String s) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {

                conn = DriverManager.getConnection(url, username, password);
                System.out.println(conn);


                String sql = "delete from  userinfo where username = ?";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, s);

                ps.executeUpdate();
                return true;


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(conn);
        }
    }


//		public boolean update(userEntity s){
////					Connection c = null;
////					try {
////						c = DBUtil.getConnection();
////						String sql = "UPDATE userinfo SET NURSING_NAME=?,SERVICE_PRICE=?,DESCRIBE1=?,INCREMENT_FLAG=?,STATUS1 =?,LEVEL_ID=? WHERE username =?;";
////						PreparedStatement ps = c.prepareStatement(sql);
////						ps.setString(1, s.getNURSING_NAME());
////						ps.setString(2, s.getSERVICE_PRICE());
////						ps.setString(3, s.getDESCRIBE1());
////						ps.setInt(4,s.getINCREMENT_FLAG());
////						ps.setInt(5, s.getSTATUS1());
////						ps.setString(6, s.getLEVEL_ID());
////						ps.setString(7, s.getusername());
////						ps.executeUpdate();
////						return true;
////					} catch (SQLException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////						return false;
////					} finally {
////						DBUtil.close(c);
////					}
////		}


    // ===============main=======================================================================
    public static void main(String[] args) {
        userinfoDao sd = new userinfoDao();
        //=======insert
//			userEntity n = new userEntity("h4544444444u","123456","1","13572099363","907721","118114","1",0);
//			sd.insert(n);
        //==========queryById
			userEntity s = sd.queryByID("111","1");
			System.out.println(s);
			if (s==null){
				System.out.println("yeah");
			}
        //===========��ȫ��
//			ArrayList<userEntity> s = new ArrayList<>();
//			s = sd.queryAll();
//			System.out.println(s);
//			sd.delete("1601041");
//			userEntity n = new userEntity("15646","mashaji","998","shufule",0,1);
//			sd.update(n);

    }
}

