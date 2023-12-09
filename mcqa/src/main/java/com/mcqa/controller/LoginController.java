package com.mcqa.controller;

import com.mcqa.bean.LoginUser;
import com.mcqa.bean.RoleType;
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
public class LoginController {
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public LoginController(UserRepository userRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/login")
    public String login(Model model) {
        LoginUser loginUser = new LoginUser();
        model.addAttribute("user", loginUser);

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") LoginUser loginUser, Model model) {
        Optional<User> user = userRepository.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
        String loggedInUsername = user.get().getFirstName() ;
        model.addAttribute("loggedInUsername", loggedInUsername);
        return user.map(value -> {
            switch (value.getRole()) {
                case ADMIN:
                    model.addAttribute("questions", questionRepository.findAll());
                    return "admin";
                case EDUCATOR:
                    model.addAttribute("users", userRepository.findAllByRole(RoleType.STUDENT));
                    return "educator";
                case STUDENT:
                    model.addAttribute("questions", questionRepository.findAll());
                    return "student";
                default:
                    return "login";
            }
        }).orElse("login");
    }
}
