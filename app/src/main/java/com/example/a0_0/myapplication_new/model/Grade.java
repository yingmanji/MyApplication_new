package com.example.a0_0.myapplication_new.model;

/**
 * Created by Administrator on 2017/4/24.
 */

public class Grade {
    private String course;
    private int score;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
