package com.example.week6.models;

public class ProfessorWithCourse {
    private int id;
    private String courseName;
    private int profId;
    private String profName;
    private int passPercentage;


    public ProfessorWithCourse(int id, String courseName, int profId, String profName, int passPercentage) {
        this.id = id;
        this.courseName = courseName;
        this.profId = profId;
        this.profName = profName;
        this.passPercentage = passPercentage;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getProfId() {
        return profId;
    }

    public String getProfName() {
        return profName;
    }

    public int getPassPercentage() {
        return passPercentage;
    }

    @Override
    public String toString() {
        return "ProfessorWithCourse{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", profId=" + profId +
                ", profName='" + profName + '\'' +
                ", passPercentage=" + passPercentage +
                '}';
    }
}
