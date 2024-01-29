package com.microservices.QuizApp;

import jakarta.persistence.*;
import lombok.Data;
@Data  //@Data - Lombok https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.30
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;

}
