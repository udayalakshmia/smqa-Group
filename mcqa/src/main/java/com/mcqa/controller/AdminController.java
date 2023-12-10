package com.mcqa.controller;

import com.mcqa.bean.Question;
import com.mcqa.bean.User;
import com.mcqa.repository.QuestionRepository;
import com.mcqa.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/")
    public String index() {
           return "redirect:/login";
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

    @GetMapping("edit-user/{id}")
    public String editUser(@PathVariable("id") long id,  Model model) {
    	User user = userRepository.findById(Long.valueOf(id).intValue()).orElse(null);
        if (user != null) {
    	 model.addAttribute("user", user);
        }
        return "update-user";
    }
    
    @PostMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") long id,  User user, Model model) {
        userRepository.save(user);
        return "redirect:/all-users";
    }
    
    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(Long.valueOf(id).intValue())
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/all-users";
    }
    
    
    @GetMapping("edit-question/{id}")
    public String editQuestion(@PathVariable("id") long id,  Model model) {
    	Question question = questionRepository.findById(Long.valueOf(id).intValue()).orElse(null);
        if (question != null) {
    	 model.addAttribute("questionObj", question);
        }
        return "update-question";
    }
    
    @PostMapping("/update-question/{id}")
    public String updateQuestion(@ModelAttribute("questionObj") Question question, Model model) {
    	questionRepository.save(question);
        return "redirect:/admin";
    }
    
    @GetMapping("/delete-question/{id}")
    public String deleteQuestion(@PathVariable("id") long id, Model model) {
        Question question = questionRepository.findById(Long.valueOf(id).intValue())
          .orElseThrow(() -> new IllegalArgumentException("Invalid Question Id:" + id));
        questionRepository.delete(question);
        return "redirect:/admin";
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
        return "educator-question";
    }

    @PostMapping("/user/{userId}/update-score")
    public String updateScore(@PathVariable Integer userId, Integer newScore) {
        // Retrieve the user by ID
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            // Update the user's score
            user.setScore(newScore);
            userRepository.save(user);
            return "redirect:/user/" + userId;
        } else {
            // Handle user not found scenario
            return "redirect:/notfound";
        }
    }
}
