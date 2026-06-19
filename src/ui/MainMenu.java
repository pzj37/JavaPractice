package ui;

import Model.Student;
import StudentTool.*;
import java.util.Scanner;

public class MainMenu {
    public static Scanner sr = new Scanner(System.in);
    private MainMenu(){};
    public static void start(){
        while (true){
            System.out.println("""
                    数字输入即可执行
                    添加学生：1
                    删除学生：2
                    修改学生：3
                    查找学生：4
                    显示全部：5
                    成绩平均值：6
                    随机生成学生：7
                    退出：0
                    """);
            String open_0 = sr.next();
            switch(open_0) {
                case "1"->{
                    addStudent();
                }
                case "2"->{
                    deleteStudent();
                }
                case "3"->{
                    setStudent();
                }
                case "4"->{
                    findStudent();
                }
                case "5"->{
                    showAllStudents();
                }
                case "6"->{
                    scgScore();
                }
                case "7"->{
                    studtGetTool();
                }
                case "0"->{
                    System.out.println("退出");
                    return;
                }
                default -> {
                    System.out.println("错误值："+open_0);
                }
            }
        }
    }
    private static void addStudent(){
        try {
            System.out.println("请输入名字：");
            String name = StudentTool.nameIsTrue(sr.next());
            System.out.println("请输入年龄：");
            int age = StudentTool.ageIsTrue(sr.nextInt());
            System.out.println("请输入成绩：");
            int score = StudentTool.scoreIsTrue(sr.nextInt());
            StudentTool.addStudent(name, age, score);
            System.out.println("添加完成");
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void deleteStudent(){
        try {
            System.out.print("请输入ID：");
            int ID = StudentTool.idIsTrue(sr.nextInt());
            StudentTool.deleteStudent(ID);
            System.out.println("删除成功");
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    private static void setStudent(){
        try {
            System.out.println("请输入ID:");
            int id = StudentTool.idIsTrue(sr.nextInt());
            Student student = StudentTool.idFind(id);
            System.out.print("请输入名字：");
            String name = StudentTool.nameIsTrue(sr.next());
            student.setName(name);
            System.out.println("请输入年龄：");
            int age = StudentTool.ageIsTrue(sr.nextInt());
            student.setAge(age);
            System.out.println("请输入成绩：");
            int score = StudentTool.scoreIsTrue(sr.nextInt());
            student.setScore(score);
            System.out.println("设置完成："+student.toString());
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    private static void findStudent(){
        try {
            System.out.print("请输入名字：");
            String name = StudentTool.nameIsTrue(sr.next());
            System.out.println("请输入年龄：");
            int age = StudentTool.ageIsTrue(sr.nextInt());
            StudentTool.nameAndAgeFind(name, age);
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    private static void showAllStudents(){
        try{
            StudentTool.showAllStudents();
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void scgScore(){
        try {
            System.out.println("当前成绩平均值："+StudentTool.scgScore());
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void studtGetTool(){
        try {
            System.out.println("输入随机生成学生的数量：");
            StudentRandomTool.getStudenTool(sr.nextInt());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
