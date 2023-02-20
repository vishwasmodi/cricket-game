package org.example.model;

public class Player {
    private Integer id;
    private String name;
    private Integer battingSkill;
    private Integer ballingSkill;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBattingSkill(Integer battingSkill) {
        this.battingSkill = battingSkill;
    }

    public void setBallingSkill(Integer ballingSkill) {
        this.ballingSkill = ballingSkill;
    }
    public Integer getId() {return id;}

    public String getName() {
        return name;
    }

    public Integer getBattingSkill() {
        return battingSkill;
    }

    public Integer getBallingSkill() {
        return ballingSkill;
    }

}