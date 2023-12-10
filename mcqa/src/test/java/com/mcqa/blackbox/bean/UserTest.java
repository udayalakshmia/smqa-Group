package com.mcqa.blackbox.bean;

import com.mcqa.bean.RoleType;
import com.mcqa.bean.User;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void testEqualsAndHashCode() {
        // Given
        User user1 = new User();
        user1.setId(1);

        User user2 = new User();
        user2.setId(1);

        User user3 = new User();
        user3.setId(2);

        // When & Then
        // Test equals method
        assertThat(user1).isEqualTo(user2);
        assertThat(user1).isNotEqualTo(user3);

        // Test hashCode method
        assertThat(user1.hashCode()).isEqualTo(user2.hashCode());
     //   assertThat(user1.hashCode()).isNotEqualTo(user3.hashCode());
    }

    @Test
    void testToString() {
        // Given
        User user = new User();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setRole(RoleType.STUDENT);
        user.setScore(100);

        // When
        String toStringResult = user.toString();

        // Then
        assertThat(toStringResult).contains("id=1", "firstName=John", "lastName=Doe", "role=STUDENT", "score=100");
    }

}