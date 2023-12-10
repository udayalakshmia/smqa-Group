package com.mcqa;


import com.mcqa.controller.AdminController;
import com.mcqa.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {



    @Autowired
    private LoginController loginController;
    @Autowired
    private AdminController adminController;

    @Test
    void contextLoads() throws Exception {
        assertThat(loginController).isNotNull();
        assertThat(adminController).isNotNull();
    }
}
