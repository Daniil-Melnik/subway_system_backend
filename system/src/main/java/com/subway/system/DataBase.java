package com.subway.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    // JDBC URL, username and password of MySQL server
    private final static String url = "jdbc:mysql://localhost:3306/subway?autoReconnect=true&useSSL=false";
    private final static String user = "root";
    private final static String password = "1234qseft";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;

    public static void main(String args[]) {
        Station st = getStByID(1);
        System.out.println(st.getId() + " " + st.getName() + " " + st.getLine_id());
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

///////////////////////////////////
// getting infopmation from s_lines
///////////////////////////////////
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

    public static Line getLineByID(int id) {
        GetDBConnection();
        Line line = new Line();
        try {
            String query = "SELECT * FROM s_lines WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            line.setLine(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("num_of_st")), rs.getString("name"), rs.getString("color"), rs.getString("abbr"));
        }
        catch (SQLException sqlEx) {
            //sqlEx.printStackTrace();
            return null;
        }finally {
            CloseDBConnection();
        }
        return line;
    }

/////////////////////////////////
// getting infopmation from Photo
/////////////////////////////////

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

/////////////////////////////////
// getting infopmation from Para
/////////////////////////////////

    public static List<Para> getParas() {
        GetDBConnection();
        String query = "select * from para";
       List<Para> ar_para = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Para para = new Para();
                para.setPara(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("station_id")), Integer.parseInt(rs.getString("section_num")), rs.getString("text"));
                ar_para.add(para);
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally {
            CloseDBConnection();
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ } 
        }
        return ar_para;
    }

    public static List<Para> getParaByStID(int id) {
        GetDBConnection();
        List<Para> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM para WHERE station_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Para para = new Para();
                para.setPara(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("station_id")), Integer.parseInt(rs.getString("section_num")), rs.getString("text"));
                list.add(para);
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

    public static Para getParaByID(int id) {
        GetDBConnection();
        Para para = new Para();
        try {
            String query = "SELECT * FROM para WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            para.setPara(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("station_id")), Integer.parseInt(rs.getString("section_num")), rs.getString("text"));
        }
        catch (SQLException sqlEx) {
            //sqlEx.printStackTrace();
            return null;
        }finally {
            CloseDBConnection();
        }
        return para;
    }

////////////////////////////////////
// getting infopmation from stations
////////////////////////////////////

    public static List<Station> getStations() {
        GetDBConnection();
        String query = "select * from stations";
       List<Station> ar_station = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Station station = new Station();
                station.setStation(Integer.parseInt(rs.getString("id")), rs.getString("name"), Integer.parseInt(rs.getString("line_id")), Integer.parseInt(rs.getString("num_of_sec")));
                ar_station.add(station);
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally {
            CloseDBConnection();
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ } 
        }
        return ar_station;
    }

    public static List<Station> getStByLineID(int id) {
        GetDBConnection();
        List<Station> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM stations WHERE line_id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Station st = new Station();
                st.setStation(Integer.parseInt(rs.getString("id")), rs.getString("name"), Integer.parseInt(rs.getString("line_id")), Integer.parseInt(rs.getString("num_of_sec")));
                list.add(st);
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

    public static Station getStByID(int id) {
        GetDBConnection();
        Station st = new Station();
        try {
            String query = "SELECT * FROM stations WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            st.setStation(Integer.parseInt(rs.getString("id")), rs.getString("name"), Integer.parseInt(rs.getString("line_id")), Integer.parseInt(rs.getString("num_of_sec")));
        }
        catch (SQLException sqlEx) {
            //sqlEx.printStackTrace();
            return null;
        }finally {
            CloseDBConnection();
        }
        return st;
    }

}