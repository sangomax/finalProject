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

    private List<Question> allCommunSpecialQuestions = new ArrayList<>();

    private List<Question> allFinalQuestions = new ArrayList<>();

    private List<Player> playerList = new ArrayList<>();

    public void readQuestions() {
        StaXParser read = new StaXParser();
        final String PATH = System.getProperty("user.dir");
        List<Question> questionsCommunSpecial = new ArrayList<>();
        questionsCommunSpecial.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/GeographyQuestions.xml"));
        questionsCommunSpecial.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/EntertainmentQuestions.xml"));
        questionsCommunSpecial.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/ArtCultureQuestions.xml"));
        questionsCommunSpecial.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/HistoryQuestions.xml"));
        questionsCommunSpecial.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/ScienceNatureQuestions.xml"));
        questionsCommunSpecial.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/SportLeisureQuestions.xml"));
        setAllCommunSpecialQuestions(questionsCommunSpecial);
    }

    public List<Question> getAllCommunSpecialQuestions() {
        return allCommunSpecialQuestions;
    }

    public void setAllCommunSpecialQuestions(List<Question> allCommunSpecialQuestions) {
        this.allCommunSpecialQuestions = allCommunSpecialQuestions;
    }

    public List<Question> getAllFinalQuestions() {
        return allFinalQuestions;
    }

    public void setAllFinalQuestions(List<Question> allFinalQuestions) {
        this.allFinalQuestions = allFinalQuestions;
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
