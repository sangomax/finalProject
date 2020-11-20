package com.example.bean;

public class Question {

    private Integer idQuestion;

    private String question;

    private String answer;

    private String clue;

    private Category category;

    private Integer type;

    public Question(Integer idQuestion, String question, String answer, String clue, Category category, Integer type) {
        this.idQuestion = idQuestion;
        this.question = question;
        this.answer = answer;
        this.clue = clue;
        this.category = category;
        this.type = type;
    }

    public Question() {
        this.idQuestion = new Integer(0);
        this.question = new String();
        this.answer = new String();
        this.clue = new String();
        this.category = new Category();
        this.type = new Integer(0);
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeDescription() {
        String typeDesc = "";
        switch (this.getType()) {
            case 1:
                typeDesc = "Normal";
                break;
            case 2:
                typeDesc = "Special";
                break;
            case 3:
                typeDesc = "Final";
                break;
        }
        return typeDesc;
    }


    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", clue='" + clue + '\'' +
                ", " + category +
                ", type=" + type +
                '}';
    }
}
