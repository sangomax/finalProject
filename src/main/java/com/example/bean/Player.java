package com.example.bean;

public class Player {

    private String namePlayer;

    private String colorPlayer;

    private Score scorePlayer;

    private Integer codePlayer;

    private String isTurn;

    private String answer;


    public Player(String namePlayer, String colorPlayer, Integer codePlayer) {
        this.namePlayer = namePlayer;
        this.colorPlayer = colorPlayer;
        this.codePlayer = codePlayer;
        this.scorePlayer = new Score();
        this.isTurn = "false";
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

    public String getIsTurn() {
        return isTurn;
    }

    public void setIsTurn(String isTurn) {
        this.isTurn = isTurn;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
