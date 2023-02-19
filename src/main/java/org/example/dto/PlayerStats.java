package org.example.dto;

public class PlayerStats {
    private Integer id;
    private String name;
    private Integer runsScored;
    private Integer wiketsTaken;

    public PlayerStats(Integer id, String name, Integer runsScored, Integer wiketsTaken) {
        this.id = id;
        this.name = name;
        this.runsScored = runsScored;
        this.wiketsTaken = wiketsTaken;
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

    public Integer getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(Integer runsScored) {
        this.runsScored = runsScored;
    }

    public Integer getWicketsTaken() {
        return wiketsTaken;
    }

    public void setWicketsTaken(Integer wiketsTaken) {
        this.wiketsTaken = wiketsTaken;
    }
}
