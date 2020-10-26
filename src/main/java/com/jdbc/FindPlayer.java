package com.jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindPlayer extends DataBaseConst{


    public ResultSet getScores() {

        try {
            connectToDb();
            String query = "SELECT coalesce(Score, 0) Score, loginPlayer AS Login, namePlayer AS Name FROM Player LEFT JOIN Score ON Player.id_player = Score.id_player ORDER BY score DESC;";
            ResultSet rs = stmt.executeQuery(query);
            disconnectDB();
            return rs;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean returnPlayer(String login) {

        try {
            connectToDb();
            String query = "SELECT * FROM Player WHERE loginPlayer='" + login + "';";
            ResultSet rs = stmt.executeQuery(query);
            disconnectDB();
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean signInPlayer(String login, char[] password) {
        try {
            ArrayList<Character> charListPassword = new ArrayList<Character>();
            for(char c: password){
                charListPassword.add(c);
            }
            connectToDb();
            Array array = conn.createArrayOf("varchar", charListPassword.toArray());
            String query = "SELECT * FROM Player WHERE loginPlayer='" + login + "' AND passwordplayer='" + array + "';";
            ResultSet rs = stmt.executeQuery(query);
            disconnectDB();
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
