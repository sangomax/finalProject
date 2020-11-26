package com.example.servingwebcontent;

import com.example.bean.Category;
import com.example.bean.Player;
import com.example.bean.Question;
import com.example.bean.Score;
import com.example.handlers.StaXParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Service
public class testeServer {

    private List<Question> allCommunSpecialQuestions;

    private List<Question> allFinalQuestions;

    private List<Player> playerList;

    private List<Question> questionsAlreadyAnswer;

    public testeServer() {
        this.allCommunSpecialQuestions = new ArrayList<>();
        this.allFinalQuestions = new ArrayList<>();
        this.playerList = new ArrayList<>();
        this.questionsAlreadyAnswer = new ArrayList<>();
        this.readQuestions();
    }

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

        List<Question> questionsFinal = new ArrayList<>();
        questionsFinal.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/FinalGeographyQuestions.xml"));
        questionsFinal.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/FinalEntertainmentQuestions.xml"));
//        questionsFinal.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/FinalArtCultureQuestions.xml"));
        questionsFinal.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/FinalHistoryQuestions.xml"));
        questionsFinal.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/FinalScienceNatureQuestions.xml"));
        questionsFinal.addAll(read.readConfig(PATH + "/src/main/java/com/example/xml/FinalSportLeisureQuestions.xml"));
        setAllFinalQuestions(questionsFinal);
    }

    public Integer getRandomNumber(int maxNum) {
        Random random = new Random();
        Integer num = random.nextInt(maxNum);
        return num != maxNum || num >= 0 ? num : getRandomNumber(maxNum);
    }

    public Question getRandomQuestion() {
        int numRandom = 0;
        if(answerEachCategory()) {
            numRandom = getRandomNumber(getAllFinalQuestions().size());
            if(getQuestionsAlreadyAnswer().contains(getAllFinalQuestions().get(numRandom))) {
                return getRandomQuestion();
            } else if(getAllFinalQuestions().get(numRandom).getType() == 2 && currentPlayer().getScorePlayer().getSpecialCorrectAnswers().contains(getAllCommunSpecialQuestions().get(numRandom))) {
                return getRandomQuestion();
            }
            return getAllFinalQuestions().get(numRandom);
        } else {
            numRandom = getRandomNumber(getAllCommunSpecialQuestions().size());
            if(getQuestionsAlreadyAnswer().contains(getAllCommunSpecialQuestions().get(numRandom))) {
                return getRandomQuestion();
            } else if(getAllCommunSpecialQuestions().get(numRandom).getType() == 2 && currentPlayer().getScorePlayer().getSpecialCorrectAnswers().contains(getAllCommunSpecialQuestions().get(numRandom).getCategory())) {
                return getRandomQuestion();
            }

            return getAllCommunSpecialQuestions().get(numRandom);
        }
    }

    public boolean answerEachCategory() {
        int count = 0;
        HashSet<Integer> categoryList = new HashSet<>();
        for(Category category: currentPlayer().getScorePlayer().getSpecialCorrectAnswers()) {
            categoryList.add(category.getCodeCategory());
        }
        return categoryList.size() == 6 ? true : false;
    }

    public String updatePlayer(Player playerTurn,Question question, boolean isCorrect) {
        String pageDestiny = "game";
        Score score = playerTurn.getScorePlayer();

        score.setNumberQuestions(score.getNumberQuestions() + 1);

        if(isCorrect){
            if(question.getType() == 2){
                score.setNumSpecialCorrectAnswers(score.getNumSpecialCorrectAnswers() + 1);
                score.getSpecialCorrectAnswers().add(question.getCategory());
            } else if(question.getType() == 3){
                pageDestiny = "score";
                playerTurn.setIsWinner("true");
            } else {
                score.setNumCorrectAnswers(score.getNumCorrectAnswers() + 1);
            }

            playerTurn.setScorePlayer(score);
            this.getPlayerList().set(this.getPlayerList().indexOf(playerTurn), playerTurn);
        } else {
            if(question.getType() == 2){
                score.setNumSpecialIncorrectAnswers(score.getNumSpecialIncorrectAnswers() + 1);
            } else {
                score.setNumIncorrectAnswers(score.getNumIncorrectAnswers() + 1);
            }
            playerTurn.setScorePlayer(score);
            this.getPlayerList().set(this.getPlayerList().indexOf(playerTurn), playerTurn);
            this.changePlayer(this.getPlayerList().indexOf(playerTurn));
        }

        this.getQuestionsAlreadyAnswer().add(question);

        return pageDestiny;
    }

    public void changePlayer(int indexCurrentPlayer) {
        int size = this.getPlayerList().size();
        if(indexCurrentPlayer == (size - 1)) {
            this.getPlayerList().get(indexCurrentPlayer).setIsTurn("false");
            this.getPlayerList().get(0).setIsTurn("true");
        } else {
            this.getPlayerList().get(indexCurrentPlayer).setIsTurn("false");
            this.getPlayerList().get(indexCurrentPlayer+1).setIsTurn("true");
        }
    }

    public Player currentPlayer() {
        for(Player player: this.getPlayerList()) {
            if(player.getIsTurn().equals("true")){
                return player;
            }
        }
        return null;
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

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Question> getQuestionsAlreadyAnswer() {
        return questionsAlreadyAnswer;
    }

    public void setQuestionsAlreadyAnswer(List<Question> questionsAlreadyAnswer) {
        this.questionsAlreadyAnswer = questionsAlreadyAnswer;
    }
}
