package com.example.servingwebcontent;

import com.example.bean.Player;
import com.example.bean.Question;
import com.example.handlers.StaXParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class testeServer {

    private List<Question> allQuestions = new ArrayList<>();

    private List<Player> playerList = new ArrayList<>();

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

    public Integer getRandomNumber(int maxNum) {
        Random random = new Random();
        Integer num = random.nextInt(maxNum);
        return num != maxNum || num >= 0 ? num : getRandomNumber(maxNum);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
