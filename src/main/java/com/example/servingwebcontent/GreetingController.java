package com.example.servingwebcontent;

import com.example.bean.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/addPlayers")
//    public String processForm(Player player) {
//        System.out.println("post" + player.getNamePlayer());
//        return "showMessage";
//    }

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

}