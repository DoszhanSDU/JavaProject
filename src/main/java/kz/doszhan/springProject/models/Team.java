package kz.doszhan.springProject.models;

import kz.doszhan.springProject.DAOs.PlayersDAO;
import kz.doszhan.springProject.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class Team {

    private int ID;
    private String name;
    private int playerNum;
    private String coach;
    private String sponsor;
    private List<Player> players = new ArrayList<>();
    PlayersDAO playersDAO;
    public Team() {
    }

    public Team(String name, String coach, String sponsor) {
        this.name = name;
        this.playerNum = 0;
        this.coach = coach;
        this.sponsor = sponsor;
    }

    @Autowired
    public Team(PlayersDAO playersDAO) {
        this.playersDAO = playersDAO;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        player.setTeam(this.name);
        players.add(player);
        if (playersDAO != null) {
            playersDAO.addPlayer(player);
        } else {
            System.out.println("inside of null");
            playersDAO = new PlayersDAO();
            playersDAO.addPlayer(player);
        }
    }



    public int getID() {
        return ID;
    }

    public void setID(int teamID) {
        this.ID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}
