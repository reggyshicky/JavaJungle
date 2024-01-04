package com.ltp.gradesubmission;

public class Grade {
    private String name;
    private String subject;
    private String score;

    public Grade(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public Grade() {
        
    }
    //copy constructor
    public Grade(Grade source) {
        this.name = source.name;
        this.subject = source.subject;
        this.score = source.score;
    }
    public String getName() {
        return this.name;
    }
    public String getSubject() {
        return this.subject;
    }
    public String getScore() {
        return this.score;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setScore(String score) {
        this.score = score;
    }
}
