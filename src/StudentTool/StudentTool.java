package StudentTool;

import Model.Student;
import StudentException.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentTool{
    private static ArrayList<Student> students = new ArrayList<>();
    public static void addStudent(String name, int age,int score) {
        students.add(new Student(nameIsTrue(name), ageIsTrue(age),scoreIsTrue(score)));
    }

    public static Student deleteStudent(int ID){
        isMin();
        for (int i = 0;i < students.size();i++){
            if(students.get(i).getID()==ID){
                return students.remove(i);
            }
        }
        return null;
    }

    public static Student idFind(int ID){
        for (Student student:students){
            if(student.getID()==ID){
                return student;
            }
        }
        return null;
    }

    public static Student[] nameAndAgeFind(String name,int age) {
        isMin();
        ArrayList<Student> arr = new ArrayList<>();
        for(Student student:students){
            if(student!=null&&student.getName().equals(name)&&student.getAge()==age){
                arr.add(student);
            }
        }
        return arr.toArray(new Student[0]);
    }

    public static void showAllStudents(){
        isMin();
        System.out.println("全部学生：");
        students.sort((s1,s2)->s2.getScore()-s1.getScore());
        for (Student student:students) {
            System.out.println(student);
        }
    }

    public static double scgScore(){
        isMin();
        double falst = 0;
        for (Student student : students) {
            falst += student.getScore();
        }
        return falst/students.size();
    }

    public static void isMin(){
        if(students.isEmpty()){
            throw new MinException("你还没有学生");
        }
    }

    public static int ageIsTrue(int age) {
        if (age<0||age>=30) {
            throw new AgeException("不可设置年龄："+age);
        }
        return age;
    }

    public static String nameIsTrue(String name) {
        if(name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            throw new NameException("不可设置名字："+name);
        }
        return name;
    }

    public static int scoreIsTrue(int score) {
        if(score<0||score>450){
            throw new NameException("不可设置成绩："+score);
        }
        return score;
    }

    public static int idIsTrue(int id){
        String now = Integer.toString(LocalDate.now().getYear());
        if(!(Integer.toString(id).matches(now+".*"))){
            throw new IdException("错误ID："+id);
        }
        return id;
    }
}
