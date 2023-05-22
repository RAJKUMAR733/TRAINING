package com.example.week6.models;

public class StudentWithCourse {
    private int studentId;
    private String name;
    private int marks;
    private int courseId;
    private String courseName;
    private Double passMarks;

    public StudentWithCourse(int studentId, String name, int marks, int courseId, String courseName, Double passMarks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.courseId = courseId;
        this.courseName = courseName;
        this.passMarks = passMarks;
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

    public Double getPassMarks() {
        return passMarks;
    }

    @Override
    public String toString() {
        return "StudentWithCourse{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", passMarks=" + passMarks +
                '}';
    }
}
