package kz.doszhan.springProject.models;

public class Team {
    private int ID;
    private String name;
    private int playerNum;
    private String coach;
    private String sponsor;

    public Team(){
    }

    public Team(String name,  String coach, String sponsor) {
        this.name = name;
        this.playerNum = 0;
        this.coach = coach;
        this.sponsor = sponsor;
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
