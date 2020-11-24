package com.example.bean;

public class Player {

    private String namePlayer;

    private String colorPlayer;

    private Score scorePlayer;

    private Integer codePlayer;


    public Player(String namePlayer, String colorPlayer, Integer codePlayer) {
        this.namePlayer = namePlayer;
        this.colorPlayer = colorPlayer;
        this.codePlayer = codePlayer;
        this.scorePlayer = new Score();
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getColorPlayer() {
        return colorPlayer;
    }

    public void setColorPlayer(String colorPlayer) {
        this.colorPlayer = colorPlayer;
    }

    public Score getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(Score scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public Integer getCodePlayer() {
        return codePlayer;
    }

    public void setCodePlayer(Integer codePlayer) {
        this.codePlayer = codePlayer;
    }
}
