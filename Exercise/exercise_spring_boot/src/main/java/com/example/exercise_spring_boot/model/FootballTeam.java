package com.example.exercise_spring_boot.model;

import javax.persistence.*;

@Entity
@Table(name = "football_team")
public class FootballTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name= "name")
    private String name;

    public FootballTeam() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
