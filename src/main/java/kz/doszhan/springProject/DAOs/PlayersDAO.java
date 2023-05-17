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
        Player player = null;
          try {
              PreparedStatement preparedStatement =
                      connection.prepareStatement("SELECT * from player where id=?");
              preparedStatement.setInt(1,index);
              ResultSet resultSet = preparedStatement.executeQuery();
              resultSet.next();
              player = new Player();
              player.setID(resultSet.getInt("id"));
              player.setGoal(resultSet.getInt("goal"));
              player.setPosition(resultSet.getString("position"));
              player.setName(resultSet.getString("name"));
              player.setNumber(resultSet.getInt("number"));
              player.setTeam(resultSet.getString("team"));
              player.setAge(resultSet.getInt("age"));
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
          return player;
      }

    public void addPlayer(Player player) {
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement
                    ("SELECT id FROM player ORDER BY id DESC LIMIT 1;");
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            PLAYER_ID = resultSet.getInt("id");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into player values (?,0,?,?,?,?,?)");
            preparedStatement.setInt(1,++PLAYER_ID);
            preparedStatement.setString(2,player.getPosition());
            preparedStatement.setString(3,player.getName());
            preparedStatement.setInt(4,player.getNumber());
            preparedStatement.setString(5,player.getTeam());
            preparedStatement.setInt(6,player.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removePlayer(int index) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from player" +
                    " where id = ?");
            preparedStatement.setInt(1,index);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePlayer(int id , Player player) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update player set " +
                    "goal=?,position= ?, name = ? " +
                    ", number = ? , team = ? , age = ? where id = ?" );
            preparedStatement.setInt(1,player.getGoal());
            preparedStatement.setString(2,player.getPosition());
            preparedStatement.setString(3,player.getName());
            preparedStatement.setInt(4,player.getNumber());
            preparedStatement.setString(5,player.getTeam());
            preparedStatement.setInt(6,player.getAge());
            preparedStatement.setInt(7,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
