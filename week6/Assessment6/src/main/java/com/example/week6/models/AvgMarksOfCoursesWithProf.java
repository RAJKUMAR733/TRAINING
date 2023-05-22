package com.example.week6.models;

public class AvgMarksOfCoursesWithProf {
    private int id;
    private String courseName;
    private int profId;
    private String profName;
    private int avgMarks;

    public AvgMarksOfCoursesWithProf(int id, String courseName, int profId, String profName, int avgMarks) {
        this.id = id;
        this.courseName = courseName;
        this.profId = profId;
        this.profName = profName;
        this.avgMarks = avgMarks;
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

    public int getAvgMarks() {
        return avgMarks;
    }

    @Override
    public String toString() {
        return "AvgMarksOfCoursesWithProf{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", profId=" + profId +
                ", profName='" + profName + '\'' +
                ", avgMarks=" + avgMarks +
                '}';
    }
}
