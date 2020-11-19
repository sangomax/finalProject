package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private Integer numberQuestions;

    private Integer numCorrectAnswers;

    private Integer numIncorrectAnswers;

    private List<Category> specialCorrectAnswers;

    public Score() {
        this.numberQuestions = new Integer(0);
        this.numCorrectAnswers = new Integer(0);
        this.numIncorrectAnswers = new Integer(0);
        this.specialCorrectAnswers = new ArrayList<>();
    }

    public Integer getNumberQuestions() {
        return numberQuestions;
    }

    public void setNumberQuestions(Integer numberQuestions) {
        this.numberQuestions = numberQuestions;
    }

    public Integer getNumCorrectAnswers() {
        return numCorrectAnswers;
    }

    public void setNumCorrectAnswers(Integer numCorrectAnswers) {
        this.numCorrectAnswers = numCorrectAnswers;
    }

    public Integer getNumIncorrectAnswers() {
        return numIncorrectAnswers;
    }

    public void setNumIncorrectAnswers(Integer numIncorrectAnswers) {
        this.numIncorrectAnswers = numIncorrectAnswers;
    }

    public List<Category> getSpecialCorrectAnswers() {
        return specialCorrectAnswers;
    }

    public void setSpecialCorrectAnswers(List<Category> specialCorrectAnswers) {
        this.specialCorrectAnswers = specialCorrectAnswers;
    }
}
