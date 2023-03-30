package kz.doszhan.springProject.DAOs;

import kz.doszhan.springProject.models.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayersDAO {

    private static int PLAYER_ID;
    List<Player> players = new ArrayList<>();
    {
        addPlayer(new Player("Doszhan",23,"defender"));
        addPlayer(new Player("Bekzhan",17,"forward"));
        addPlayer(new Player("Ula",25,"goalkeeper"));
    }

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
