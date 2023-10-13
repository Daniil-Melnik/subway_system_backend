package com.subway.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java program to connect to MySQL database running on localhost and
 * running SELECT and INSERT query to retrieve and add data.
 * @author Javin Paul
 */
public class DataBase {

    // JDBC URL, username and password of MySQL server
    private final static String url = "jdbc:mysql://localhost:3306/subway?autoReconnect=true&useSSL=false";
    private final static String user = "root";
    private final static String password = "1234qseft";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;

    public static void main(String args[]) {
        
    }

    private static void GetDBConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private static void CloseDBConnection() {
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
    }

    public static List<Line> getLines() {
        GetDBConnection();
        String query = "select * from s_lines";
       List<Line> ar_line = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Line line = new Line();
                line.setLine(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("num_of_st")), rs.getString("name"), rs.getString("color"), rs.getString("abbr"));
                ar_line.add(line);
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally {
            CloseDBConnection();
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ } 
        }
        return ar_line;
    }

    public static List<Photo> getPhotos() {
        GetDBConnection();
        String query = "select * from photo";
       List<Photo> ar_photo = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Photo photo = new Photo();
                photo.setPhoto(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("station_id")), Integer.parseInt(rs.getString("section_num")), rs.getString("src"), rs.getString("caption"));
                ar_photo.add(photo);
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally {
            CloseDBConnection();
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ } 
        }
        return ar_photo;
    }

    public static List<Photo> getPhotoByStID(int id) {
        GetDBConnection();
        List<Photo> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM photo WHERE station_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Photo photo = new Photo();
                photo.setPhoto(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("station_id")), Integer.parseInt(rs.getString("section_num")), rs.getString("src"), rs.getString("caption"));
                list.add(photo);
            }
        }
        catch (SQLException sqlEx) {
            //sqlEx.printStackTrace();
            return null;
        }finally {
            CloseDBConnection();
        }
        return list;
    }

    public static Photo getPhotoByID(int id) {
        GetDBConnection();
        Photo photo = new Photo();
        try {
            String query = "SELECT * FROM photo WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            photo.setPhoto(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("station_id")), Integer.parseInt(rs.getString("section_num")), rs.getString("src"), rs.getString("caption"));
        }
        catch (SQLException sqlEx) {
            //sqlEx.printStackTrace();
            return null;
        }finally {
            CloseDBConnection();
        }
        return photo;
    }
}