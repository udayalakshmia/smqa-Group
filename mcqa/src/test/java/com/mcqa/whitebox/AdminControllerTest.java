package com.mcqa.whitebox;

import com.mcqa.bean.Question;
import com.mcqa.bean.User;
import com.mcqa.controller.AdminController;
import com.mcqa.repository.QuestionRepository;
import com.mcqa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



class AdminControllerTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private QuestionRepository questionRepository;

  @Mock
  private Model model;

  @InjectMocks
  private AdminController adminController;

  public AdminControllerTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void admin_shouldReturnAdminPage() {
    String result = adminController.admin(model);

    assertEquals("admin", result);
    verify(questionRepository, times(1)).findAll();
    verify(model, times(1)).addAttribute(eq("questions"), any());
  }



  @Test
  void addUser_shouldNotSaveUserIfEmailExists() {
    User user = new User();
    user.setId(1);
    user.setEmail("nick.fury@gmail.com");
    List<User> existingUsers = new ArrayList<>();
    existingUsers.add(new User()); // Assuming there is an existing user with any email
    when(userRepository.findByEmail(anyString())).thenReturn(existingUsers);

    String result = adminController.addUser(user, model);

    assertEquals("all-users", result); // Should return to add-user page
   verify(userRepository, never()).save(user); // Should not save the user

  }

  @Test
  void addQuestion_shouldReturnAdminPage() {
    Question question = new Question();

    String result = adminController.addQuestion(question, model);

    assertEquals("admin", result);
    verify(model, times(1)).addAttribute(eq("questions"), any());
  }
}