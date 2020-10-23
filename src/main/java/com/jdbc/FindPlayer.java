package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindPlayer extends DataBaseConst {


    public ResultSet getScores(){

        try {
            connectToDb();
            String query = "SELECT Score, loginPlayer, namePlayer FROM Player LEFT JOIN Score ON Player.id_player = Score.id_player ORDER BY score DESC;";
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


}
