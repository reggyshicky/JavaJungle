package com.microservices.QuizApp.Model;

import jakarta.persistence.*;
import lombok.Data;
@Data  //@Data - Lombok https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.30
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String rightAnswer;
}
