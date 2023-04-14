package kz.doszhan.springProject.DAOs;

import kz.doszhan.springProject.models.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayersDAO {

    private static int PLAYER_ID;
    private static List<Player> players = new ArrayList<>();


    public List<Player> list() {
        return players;
    }

    public Player getPlayer(int index) {
        return players.stream().filter(p -> p.getID() == index).findAny().orElse(null);
    }

    public void addPlayer(Player player) {
        player.setID(++PLAYER_ID);
        players.add(player);
    }

    public void removePlayer(int index) {
        players.removeIf(p -> p.getID()==index);
    }

    public void updatePlayer(int id , Player player) {
        getPlayer(id).setName(player.getName());
        getPlayer(id).setNumber(player.getNumber());
        getPlayer(id).setPosition(player.getPosition());
    }



}
