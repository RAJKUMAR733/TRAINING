package com.example.week6.models;

public class StudentWithPercenatge {
    String name;
    private Double percentage;

    public StudentWithPercenatge(String name, Double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public Double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "StudentWithPercenatge{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
