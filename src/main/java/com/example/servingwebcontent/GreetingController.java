package com.example.servingwebcontent;

import com.example.bean.Player;
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

    public GreetingController() {
        this.testeServer.readQuestions();
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(name);
        return "greeting";
    }

    @GetMapping("/addPlayers")
    public String sendForm(Player player) {
//        System.out.println("get" + player.getNamePlayer());
        this.testeServer.setPlayerList(new ArrayList<>());
        return "addPlayers";
    }

    @RequestMapping("/playFeild")
    public String playFeild() {
        System.out.println("Let's play!");
        return "playFeild";
    }

    @GetMapping("/listQuestions")
    public String showAll(Model model) {

        model.addAttribute("questions", this.testeServer.getAllQuestions());
        int questionNumber = this.testeServer.getRandomNumber(this.testeServer.getAllQuestions().size());
        model.addAttribute("randonQuestion", this.testeServer.getAllQuestions().get(questionNumber));
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
        return "game";
    }

    @PostMapping("/game")
    public String game(Model model) {
        model.addAttribute("players", testeServer.getPlayerList());
        for(Player player: this.testeServer.getPlayerList())
        {
            System.out.println(player.getNamePlayer());
            System.out.println(player.getColorPlayer());
        }

        System.out.println("Let's play!");
        return "game";
    }

    @GetMapping("/score")
    public String sendForm(Score score) {
        System.out.println("get" + score.getNumCorrectAnswers());
        return "score";
    }
//    @RequestMapping(value = "addPlayers", method = RequestMethod.POST)
//    public String setPlayer(Player player, Model model) {
//        Object ob = model.getAttribute("player");
//        this.testeServer.getPlayerList().add((Player) ob);
//        return "addPlayers";
//    }

}