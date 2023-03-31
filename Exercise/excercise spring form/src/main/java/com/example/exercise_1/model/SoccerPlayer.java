package com.example.exercise_1.model;

public class SoccerPlayer {

    private int id;
    private String code;
    private String name;
    private String dateOfBirthday;
    private String exp;
    private String location;
    private String img;

    public SoccerPlayer() {
    }

    public SoccerPlayer(int id, String code, String name, String dateOfBirthday, String exp, String location, String img) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.exp = exp;
        this.location = location;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
