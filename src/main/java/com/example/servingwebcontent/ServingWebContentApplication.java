package com.example.servingwebcontent;

import com.example.bean.Question;
import com.example.handlers.StaXParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ServingWebContentApplication {

    private List<Question> allQuestions = new ArrayList<>();

    public static void main(String[] args) {
        ServingWebContentApplication serv = new ServingWebContentApplication();

        SpringApplication.run(serv.getClass(), args);

        serv.readQuestions();

    }

    public void readQuestions() {
        StaXParser read = new StaXParser();

        List<Question> readQuestions = read.readConfig(System.getProperty("user.dir") + "/src/main/java/com/example/xml/questions.xml");
        for (Question item : readQuestions) {
            getAllQuestions().add(item);
        }
    }

    public List<Question> getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(List<Question> allQuestions) {
        this.allQuestions = allQuestions;
    }
}