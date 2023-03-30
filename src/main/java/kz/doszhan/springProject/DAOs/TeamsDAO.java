package kz.doszhan.springProject.DAOs;

import kz.doszhan.springProject.models.Player;
import kz.doszhan.springProject.models.Team;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamsDAO {
    private static int TEAM_ID;
    private List<Team> teamList = new ArrayList<>();
    {
        teamList.add(new Team("Liverpool","Klopp","Fly Emirates"));
        teamList.add(new Team("Barcelona","Pep","Oracle"));
        teamList.add(new Team("Kayrat","Kaka","Pari Match"));
    }

    public List<Team> list() {
        return teamList;
    }

    public Team getTeam(int id) {
        return teamList.stream().filter(t -> t.getID() == id).findAny().orElse(null);
    }

    public void addTeam(Team team) {
        team.setID(++TEAM_ID);
        teamList.add(team);
    }

    public void editTeam(Team team , int id) {
        getTeam(id).setName(team.getName());
        getTeam(id).setCoach(team.getCoach());
        getTeam(id).setSponsor(team.getSponsor());
    }

    public void deleteTeam(int id){
        teamList.removeIf(t->t.getID()==id);
    }


}
