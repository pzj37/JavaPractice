package StudentTool;

import Model.Student;
import StudentException.*;
import java.time.LocalDate;

public class StudentTool{
    public static void addStudent(String name, int age,int score) {
        isMax();
        StudentMax.max[StudentMax.Now++] = new Student(nameIsTrue(name), ageIsTrue(age),scoreIsTrue(score));
    }

    public static void deleteStudent(int ID){
        isMin();
        int i =idFindToScore(ID);
        System.out.println("删除了"+ StudentMax.max[i]);
        StudentMax.max[i] =null;
        for(int m = i;i+1<StudentMax.max.length;i++){
                StudentMax.max[i]=StudentMax.max[i+1];
        }
    }

    public static Student idFind(int ID) {
        isMin();
        for (int i = 0; i < StudentMax.max.length; i++) {
            if (StudentMax.max[i] != null && StudentMax.max[i].getID() == ID) {
                System.out.println(StudentMax.max[i]);
                return StudentMax.max[i];
            }
        }
        throw new IdException("没找到ID：" + ID);
    }
    public static int idFindToScore(int ID) {
        isMin();
        for (int i = 0; i < StudentMax.max.length; i++) {
            if (StudentMax.max[i] != null && StudentMax.max[i].getID() == ID) {
                System.out.println(StudentMax.max[i]);
                return i;
            }
        }
        throw new IdException("没找到ID：" + ID);
    }


    public static void nameAndAgeFind(String name,int age) {
        isMin();
        for(Student student:StudentMax.max){
            if(student!=null&&student.getName().equals(name)&&student.getAge()==age){
                System.out.println(student);
            }
        }
    }

    public static void showAllStudents(){
        isMin();
        System.out.println("全部学生：");
        for (int i = 0;i<StudentMax.Now;i++) {
            for (int j=i;j-1>=0&&StudentMax.max[j].getScore()>StudentMax.max[j-1].getScore();j--) {
                Student next = StudentMax.max[j];
                StudentMax.max[j] = StudentMax.max[j-1];
                StudentMax.max[j-1] = next;
            }
        }
        for (Student student:StudentMax.max) {
            if(student!=null) System.out.println(student);
        }
    }

    public static double scgScore(){
        isMin();
        double falst = 0;
        for (int i = 0; i < StudentMax.Now; i++) {
            falst+=StudentMax.max[i].getScore();
        }
        return falst/StudentMax.Now;
    }

    public static void isMin(){
        if(StudentMax.Now == 0){
            throw new MinException("你还没有学生");
        }
    }

    public static void isMax(){
        if(StudentMax.Now==StudentMax.max.length){
            throw new MaxException("人满了");
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

    private static final class StudentMax{
        static int Now;
        static Student[] max = new Student[100];
    }
}
