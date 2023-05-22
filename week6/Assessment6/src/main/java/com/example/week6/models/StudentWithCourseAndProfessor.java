package com.example.week6.models;

public class StudentWithCourseAndProfessor {
    private int studentId;
    private String name;
    private int marks;
    private int courseId;
    private String courseName;
    private String passMarks;
    private int profId;
    private String profName;
    private String profdeg;

    public StudentWithCourseAndProfessor(int studentId, String name, int marks, int courseId, String courseName, String passMarks, int profId, String profName, String profdeg) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.courseId = courseId;
        this.courseName = courseName;
        this.passMarks = passMarks;
        this.profId = profId;
        this.profName = profName;
        this.profdeg = profdeg;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getPassMarks() {
        return passMarks;
    }

    public int getProfId() {
        return profId;
    }

    public String getProfName() {
        return profName;
    }

    public String getProfdeg() {
        return profdeg;
    }

    @Override
    public String toString() {
        return "StudentWithCourseAndProfessor{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", passMarks='" + passMarks + '\'' +
                ", profId=" + profId +
                ", profName='" + profName + '\'' +
                ", profdeg='" + profdeg + '\'' +
                '}';
    }
}
