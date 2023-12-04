package com.mcqa.controller;

import com.mcqa.repository.QuestionRepository;
import com.mcqa.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public AdminController(UserRepository userRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("admin")
    public String admin(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "admin";
    }

    @GetMapping("all-users")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "all-users";
    }

    @GetMapping("add-user")
    public String addUser(Model model) {
        return "add-user";
    }

    @GetMapping("add-question")
    public String allQuestion(Model model) {
        return "add-question";
    }
}
