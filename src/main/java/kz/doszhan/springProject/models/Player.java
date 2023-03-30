package kz.doszhan.springProject.models;

public class Player {

    private String name;
    private String team;
    private int number;
    private String position ;
    private int goal;
    private int ID;
    public Player(String name, int number, String position) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.goal = 0;
    }
    public Player(){
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
