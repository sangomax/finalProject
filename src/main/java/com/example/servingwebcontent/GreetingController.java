package com.example.servingwebcontent;

import com.example.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println(name);
        return "greeting";
    }

    @GetMapping("/addUser")
    public String sendForm(User user) {
        System.out.println("get" + user.getName());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String processForm(User user) {
        System.out.println("post" + user.getName());
        return "showMessage";
    }

}