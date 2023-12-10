package com.mcqa.blackbox.bean;

import com.mcqa.bean.Question;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void testEqualsAndHashCode() {
        // Given
        Question question1 = new Question();
        question1.setId(1);

        Question question2 = new Question();
        question2.setId(1);

        Question question3 = new Question();
        question3.setId(88);

        // When & Then
        // Test equals method
        assertThat(question1).isEqualTo(question2);
        assertThat(question1).isNotEqualTo(question3);

        // Test hashCode method
        assertThat(question1.hashCode()).isEqualTo(question2.hashCode());
    //    assertThat(question1.hashCode()).isNotEqualTo(question3.hashCode());
    }

    @Test
    void testToString() {
        // Given
        Question question = new Question();
        question.setId(1);
        question.setQuestion("What is the capital of France?");
        question.setOption1("Paris");
        question.setOption2("Berlin");
        question.setOption3("London");
        question.setOption4("Madrid");
        question.setCorrectOption("Paris");

        // When
        String toStringResult = question.toString();

        // Then
        assertThat(toStringResult).contains("id=1", "question=What is the capital of France?", "correctOption=Paris");
    }

}