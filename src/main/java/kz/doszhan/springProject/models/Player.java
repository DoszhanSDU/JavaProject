package kz.doszhan.springProject.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Player {
    @NotEmpty(message = "Name should not be empty" )
    @Size(min = 2 , max = 30 , message = "Name size should be between 2-30 characters")
    private String name;
    private String team;
    @Min(value = 0 , message = "Age should be non negative number")
    private int age;
    @Min(value = 1 , message = "Number should be between 1-99")
    @Max(value = 99, message = "Number should be between 1-99")
    private int number;
    @NotEmpty(message = "player should have a position")
    private String position ;
    private int goal;
    private int ID;

    public Player(String name, int number, String position) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.goal = 0;
    }

    public Player() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
