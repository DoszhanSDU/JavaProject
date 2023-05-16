package kz.doszhan.springProject.DAOs;

import kz.doszhan.springProject.models.Player;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayersDAO {

    private static int PLAYER_ID;
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String username = "postgres";
    private static final String password = "59905990Dd";

    private static Connection connection ;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Player> list() {
        List<Player> players = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from player";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Player player = new Player();
                player.setID(resultSet.getInt("id"));
                player.setGoal(resultSet.getInt("goal"));
                player.setNumber(resultSet.getInt("number"));
                player.setAge(resultSet.getInt("age"));
                player.setPosition(resultSet.getString("position"));
                player.setName(resultSet.getString("name"));
                player.setTeam(resultSet.getString("team"));

                players.add(player);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return players;
    }

      public Player getPlayer(int index) {
        return null;
     }

    public void addPlayer(Player player) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "insert into player values(" + (++PLAYER_ID) + ","
                    + 0 + ",'" + player.getPosition() + "','"
                    + player.getName() + "'," + player.getNumber()
                    + ",'" + player.getTeam() + "'," + player.getAge() + ")";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removePlayer(int index) {

    }

    public void updatePlayer(int id , Player player) {

    }



}
