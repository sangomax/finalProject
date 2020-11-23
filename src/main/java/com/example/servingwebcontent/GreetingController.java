package com.example.servingwebcontent;

import com.example.bean.Player;
import com.example.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        System.out.println("get" + player.getNamePlayer());
        return "addPlayers";
    }

    @GetMapping("/listQuestions")
    public String showAll(Model model) {

        model.addAttribute("questions", this.testeServer.getAllQuestions());
        int questionNumber = this.testeServer.getRandomNumber(this.testeServer.getAllQuestions().size());
        model.addAttribute("randonQuestion", this.testeServer.getAllQuestions().get(questionNumber));
        return "listQuestions";
    }

    @PostMapping("/addUser")
    public String processForm(User user) {
        System.out.println("post" + user.getName());
        return "showMessage";
    }

}