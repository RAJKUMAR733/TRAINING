package com.example.week6.service;
import com.example.week6.models.*;
import com.example.week6.utility.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Format {
    public static void percentage()
    {
        try{
            Connection con=ConnectionProvider.connectionProvider();
            String query = "SELECT Name,sum(Marks)/6 as Percentage FROM data.students group by Name;";
            Statement statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery(query);
            List<StudentWithPercenatge> studentWithPercenatgeList=new ArrayList<>();

            while (resultSet.next()){
                studentWithPercenatgeList.add(
                        new StudentWithPercenatge(resultSet.getString(1),
                                Double.parseDouble(resultSet.getString(2))));
            }
            studentWithPercenatgeList.stream().forEach((n)->System.out.println(n));
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void takingInput()
    {
        Scanner scn=new Scanner(System.in);
        try {
            System.out.println("Perform the following task:");
            System.out.println("1.Overall % each student");
            System.out.println("2.Top 3 and bottom 3 students in each course along with course details");
            System.out.println("3.List of students who failed in atleast one subject along with course and prof details");
            System.out.println("4.Pass percentage of each course along with course and professor details");
            System.out.println("5.Professor details along with the average marks obtained in the course he/she taught.");
            System.out.println("6.Professor details  along with course details who have atleast 50% pass percentage in their subject");
            System.out.println("0.exit");
            int n=scn.nextInt();
            switch (n){
                case 1:
                    percentage();
                    takingInput();
                case 2:
                    topAndBottom3();
                    takingInput();
                case 3:
                    failedStudent();
                    takingInput();
                case 4:
                    passPercetage();
                    takingInput();
                case 5:
                    averageMarksWithProfessorDetails();
                    takingInput();
                case 6:
                    professorDetailsAlongwithCourseDetails();
                    takingInput();
                case 0:
                    System.exit(0);
                default:throw new RuntimeException("enter a valid code");
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            takingInput();
        }
    }

    private static void professorDetailsAlongwithCourseDetails() {
        try{
            Connection connection = ConnectionProvider.connectionProvider();
            String query = "select courses.id,courses.name as course_name,professors.id,professors.name as professor_name, count(case when students.marks >= courses.pass_marks then 1 end)*100/count(*) as pass_students from students join courses on students.course_id = courses.id join professors on courses.professor_id = professors.id group by courses.id";
            Statement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery(query);
            List<ProfessorWithCourse>professorWithCourseList=new ArrayList<>();

            while (resultSet.next()){
                professorWithCourseList.add(new ProfessorWithCourse(resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getInt(3)
                        ,resultSet.getString(4),resultSet.getInt(5)));
            }
            professorWithCourseList.stream().forEach((n)->System.out.println(n));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void averageMarksWithProfessorDetails() {

        try{
            Connection connection = ConnectionProvider.connectionProvider();
            String query = "select courses.id,courses.name as course_name,professors.id,professors.name as professor_name, avg(students.marks) as avg_marks from students join courses on students.course_id = courses.id join professors on courses.professor_id = professors.id group by courses.id";
            Statement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery(query);
            List<AvgMarksOfCoursesWithProf>avgMarksOfCoursesWithProfs=new ArrayList<>();


            while (resultSet.next()){
                avgMarksOfCoursesWithProfs.add(new AvgMarksOfCoursesWithProf(resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),
                        resultSet.getInt(5)));}
            avgMarksOfCoursesWithProfs.stream().forEach((n)->System.out.println(n));
            connection.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void passPercetage() {
        try{
            Connection con = ConnectionProvider.connectionProvider();
            String query = "select * from (select courses.id as course_id,courses.name as course_name,professors.id as professor_id,professors.name as professor_name, count(case when students.marks >= courses.pass_marks then 1 end)*100/count(*) as pass_percentage from students join courses on students.course_id = courses.id join professors on courses.professor_id = professors.id group by courses.id) pass_student where pass_percentage>50";
            Statement statement = con.prepareStatement(query);


            ResultSet resultSet = statement.executeQuery(query);
            List<ProfAndCourseWithPerc>profAndCourseWithPercList=new ArrayList<>();

            while (resultSet.next()){
                profAndCourseWithPercList.add(new ProfAndCourseWithPerc(resultSet.getInt(1)
                ,resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),
                        resultSet.getInt(5)));
                }
            profAndCourseWithPercList.stream().forEach((n)->System.out.println(n));
            con.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    private static void failedStudent() {

        try{
            Connection con = ConnectionProvider.connectionProvider();
            String query = "select * from students join courses on students.course_id = courses.id " +
                    "join professors on courses.professor_id = professors.id where students.marks < courses.pass_marks";
            Statement statement = con.prepareStatement(query);


            ResultSet resultSet = statement.executeQuery(query);
            List<StudentWithCourseAndProfessor>list=new ArrayList<>();

            while (resultSet.next()){
                list.add(new StudentWithCourseAndProfessor( resultSet.getInt(1), resultSet.getString(2)
                ,resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(6),resultSet.getString(7),
                        resultSet.getInt(8),resultSet.getString(10),resultSet.getString(11)));

                         }
            con.close();
            list.stream().forEach((n)->System.out.println(n));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void topAndBottom3() {

        top3().stream().forEach((n)->System.out.println(n));
        bottom3().stream().forEach((n)->System.out.println(n));
    }
    private static List<StudentWithCourse> top3(){
        try{
            Connection con = ConnectionProvider.connectionProvider();
            String query = "select * from (select students.Id, students.Name, students.Marks,students.CourseId, courses.name as course_name, courses.PassMarks, row_number() over (partition by courses.Id order by Marks desc) student_rank from students join courses on students.CourseId = courses.Id) Marks where student_rank<=3";
            Statement statement = con.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery(query);
            List<StudentWithCourse>studentWithCourseList=new ArrayList<>();

            while (resultSet.next()){
                studentWithCourseList.add(new StudentWithCourse(resultSet.getInt(1),resultSet.getString(2)
                ,resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),
                        Double.parseDouble(resultSet.getString(6))));
            }
            con.close();
            return studentWithCourseList;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
    private static List<StudentWithCourse>bottom3()
    {
        try{
            Connection con = ConnectionProvider.connectionProvider();
            String query = "select * from (select students.id, students.name, students.marks,students.course_id, courses.name as course_name, courses.pass_marks, " +
                    "" + "from students join courses on students.course_id = courses.id) marks where student_rank<=3";
            Statement statement = con.prepareStatement(query);

            //update query
            ResultSet resultSet = statement.executeQuery(query);
            List<StudentWithCourse>studentWithCourseList=new ArrayList<>();

            while (resultSet.next()){
                studentWithCourseList.add(new StudentWithCourse(resultSet.getInt(1),resultSet.getString(2)
                        ,resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),
                        Double.parseDouble(resultSet.getString(6))));
            }
            con.close();
            return studentWithCourseList;


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
