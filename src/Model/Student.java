package Model;

import java.time.LocalDate;

public class Student{
    private static int IdScore;
    private final int ID;
    private String name;
    private int age;
    private int score;

    public Student(String name,int age,int score){
        this.ID = LocalDate.now().getYear()*10000 +IdScore;
        this.name = name;
        this.age = age;
        this.score = score;
        IdScore++;
    }

    public int getID() {
        return ID;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString(){
        return "Student{name="+name+",ID="+ID+",age="+age+",score="+score+"}";
    }
}
