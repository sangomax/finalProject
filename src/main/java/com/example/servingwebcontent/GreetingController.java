package com.example.servingwebcontent;

import com.example.bean.Player;
import com.example.bean.Question;
import com.example.bean.Score;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class GreetingController {

    testeServer testeServer = new testeServer();

    Question question;
    Player playerTurn;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/addPlayers")
    public String sendForm(Player player) {
//        System.out.println("get" + player.getNamePlayer());
        this.testeServer.setPlayerList(new ArrayList<>());
        return "addPlayers";
    }

    @GetMapping("/listQuestions")
    public String showAll(Model model) {

        model.addAttribute("questions", this.testeServer.getAllCommunSpecialQuestions());
        int questionNumber = this.testeServer.getRandomNumber(this.testeServer.getAllCommunSpecialQuestions().size());
        model.addAttribute("randonQuestion", this.testeServer.getAllCommunSpecialQuestions().get(questionNumber));
        return "listQuestions";
    }

    @PostMapping("/addPlayers")
    public String processForm(Player player, Model model) {
        Object ob = model.getAttribute("player");
        String[] name = player.getNamePlayer().split(",");
        String[] color = player.getColorPlayer().split(",");
        for(int i = 0; i < name.length; i++) {
            this.testeServer.getPlayerList().add(new Player(name[i],color[i],(i+1)));
        }
        model.addAttribute("players", this.testeServer.getPlayerList());
        return "/game";
    }

    @PostMapping("/again")
    public String again(Player player, Model model) {
        for(int i = 0; i < this.testeServer.getPlayerList().size(); i++) {
            this.testeServer.getPlayerList().get(i).setScorePlayer(new Score());
            this.testeServer.getPlayerList().get(i).setIsWinner("false");
            this.testeServer.getPlayerList().get(i).setIsTurn("false");
        }
        this.testeServer.getPlayerList().get(0).setIsTurn("true");
        this.question = this.testeServer.getRandomQuestion();
        this.playerTurn = this.testeServer.getPlayerList().get(0);
        model.addAttribute("randonQuestion", this.question);
        model.addAttribute("players", this.testeServer.getPlayerList());
        return "game";
    }

    @PostMapping("/game")
    public String game(Player player, Model model) {
        Object ob = model.getAttribute("player");
        String[] name = player.getNamePlayer().split(",");
        String[] color = player.getColorPlayer().split(",");
        for(int i = 0; i < name.length; i++) {
            this.testeServer.getPlayerList().add(new Player(name[i],color[i],(i+1)));
        }
        this.testeServer.getPlayerList().get(0).setIsTurn("true");

        this.question = this.testeServer.getRandomQuestion();
        this.playerTurn = this.testeServer.getPlayerList().get(0);
        model.addAttribute("randonQuestion", this.question);
        model.addAttribute("players", this.testeServer.getPlayerList());
        return "game";
    }


    @RequestMapping(value = "answer")
    public String answerQuestion(Player player, Model model, Question randonQuestion, String answer) {
        String pageDirect;
        if(answer.equalsIgnoreCase(this.question.getAnswer())) {
            pageDirect = this.testeServer.updatePlayer(this.playerTurn, this.question, true);
        } else {
            pageDirect = this.testeServer.updatePlayer(this.playerTurn, this.question, false);
            this.playerTurn = this.testeServer.currentPlayer();
        }

        player.setAnswer("");

        this.question = this.testeServer.getRandomQuestion();
        model.addAttribute("randonQuestion", this.question);
        model.addAttribute("players", this.testeServer.getPlayerList());

        return pageDirect;
    }

    @GetMapping("/score")
    public String sendForm(Player player, Model model) {
        model.addAttribute("players", this.testeServer.getPlayerList());

        return "score";
    }

}