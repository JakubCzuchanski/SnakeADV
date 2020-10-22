package com.jdbc;

import java.sql.*;

public class DataBaseConst {

    protected static final String JDBC_DRIVER = "org.postgresql.Driver";
    protected static final String URL = "jdbc:postgresql://localhost/SnakeADV";
    protected static final String LOGIN = "postgres";
    protected static final String PASSWORD = "maslo1234";

    protected Statement stmt;
    protected Connection conn;
    protected PreparedStatement prepStmt;

    protected void connectToDb() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        stmt = conn.createStatement();

    }
    protected void disconnectDB() throws SQLException {
        stmt.close();
        conn.close();

    }

    protected int returnNextID(String tableName) {

        int nextID = -1;
        try {
            connectToDb();

            prepStmt = conn.prepareStatement("SELECT MAX(id_player) FROM ?;");
            prepStmt.setString(1, tableName);

            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            nextID = rs.getInt("max") + 1;
            disconnectDB();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        System.out.println("\u001B[33m" + nextID + "\u001B[0m");


        return nextID;
    }
}
