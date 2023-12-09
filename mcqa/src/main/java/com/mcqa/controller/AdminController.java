package com.mcqa.controller;

import com.mcqa.bean.Question;
import com.mcqa.bean.User;
import com.mcqa.repository.QuestionRepository;
import com.mcqa.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }


     @GetMapping("add-question-educator")
    public String allQuestionEducator(Model model) {
        Question question = new Question();
        model.addAttribute("questionObj", question);
        return "add-question-educator";
    }

    @PostMapping("add-user")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        user.setId(null);
        if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
            userRepository.save(user);
        }
        model.addAttribute("users", userRepository.findAll());
        return "all-users";
    }

    @PostMapping("add-question")
    public String addQuestion(@ModelAttribute("questionObj") Question question, Model model) {
        question.setId(null);
        questionRepository.save(question);
        model.addAttribute("questions", questionRepository.findAll());
        return "admin";
    }

    @GetMapping("add-question")
    public String allQuestion(Model model) {
        Question question = new Question();
        model.addAttribute("questionObj", question);
        return "add-question";
    }


     @PostMapping("add-question-educator")
    public String addQuestionEducator(@ModelAttribute("questionObj") Question question, Model model) {
        question.setId(null);
        questionRepository.save(question);
        model.addAttribute("questions", questionRepository.findAll());
        return "educator";
    }
}
