package com.mcqa.blackbox;
import com.mcqa.bean.LoginUser;
import com.mcqa.bean.RoleType;
import com.mcqa.bean.User;
import com.mcqa.controller.LoginController;
import com.mcqa.repository.QuestionRepository;
import com.mcqa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class LoginControllerTest {

  @Mock private UserRepository userRepository;

  @Mock private QuestionRepository questionRepository;

  @Mock private Model model;

  @InjectMocks private LoginController loginController;

  public LoginControllerTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void login_shouldReturnLoginPage() {
    String result = loginController.login(model);

    assertEquals("login", result);
    verify(model, times(1)).addAttribute(eq("user"), any());
  }

  @Test
  void login_shouldReturnAdminPageForAdminUser() {
    LoginUser loginUser = new LoginUser();
    loginUser.setEmail("admin@example.com");
    loginUser.setPassword("adminPass");

    User adminUser = new User();
    adminUser.setRole(RoleType.ADMIN);

    when(userRepository.findByEmailAndPassword(anyString(), anyString()))
        .thenReturn(Optional.of(adminUser));

    String result = loginController.login(loginUser, model);

    assertEquals("admin", result);
    verify(questionRepository, times(1)).findAll();
    verify(model, times(1)).addAttribute(eq("questions"), any());
  }

  @Test
  void login_shouldReturnEducatorPageForEducatorUser() {
    LoginUser loginUser = new LoginUser();
    loginUser.setEmail("educator@example.com");
    loginUser.setPassword("educatorPass");

    User educatorUser = new User();
    educatorUser.setRole(RoleType.EDUCATOR);

    when(userRepository.findByEmailAndPassword(anyString(), anyString()))
        .thenReturn(Optional.of(educatorUser));

    String result = loginController.login(loginUser, model);

    assertEquals("educator", result);
    verify(userRepository, times(1)).findAllByRole(RoleType.STUDENT);
    verify(model, times(1)).addAttribute(eq("users"), any());
  }

  @Test
  void login_shouldReturnStudentPageForStudentUser() {
    LoginUser loginUser = new LoginUser();
    loginUser.setEmail("student@example.com");
    loginUser.setPassword("studentPass");

    User studentUser = new User();
    studentUser.setRole(RoleType.STUDENT);

    when(userRepository.findByEmailAndPassword(anyString(), anyString()))
        .thenReturn(Optional.of(studentUser));

    String result = loginController.login(loginUser, model);

    assertEquals("student", result);
    verify(questionRepository, times(1)).findAll();
    verify(model, times(1)).addAttribute(eq("questions"), any());
  }

  @Test
  void login_shouldReturnLoginPageForInvalidUser() {
    LoginUser loginUser = new LoginUser();
    loginUser.setEmail("invalid@example.com");
    loginUser.setPassword("invalidPass");

    when(userRepository.findByEmailAndPassword(anyString(), anyString()))
        .thenReturn(Optional.empty());

    String result = loginController.login(loginUser, model);

    assertEquals("login", result);
    verify(model, never()).addAttribute(any(), any());
  }
    }