package com.subway.system;

import java.sql.Connection;
import java.sql.DriverManager;
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
        List<Line> list = getLines();

        for (int i = 0 ; i < list.size(); i++) {
            Line line = list.get(i);
            System.out.println(line.getId() + " " + line.getName() + " " + line.getNumOfSt() + " " + line.getColor());
        }
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
            //close connection ,stmt and resultset here
            CloseDBConnection();
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ } 
            //try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return ar_line;
    }
}