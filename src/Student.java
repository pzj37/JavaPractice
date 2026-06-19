import java.time.LocalDate;

public class Student{
    private static int IdScore;
    private final int ID;
    private String name;
    private int age;

    public Student(String name,int age){
        this.ID = LocalDate.now().getYear()*10000 +IdScore;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString(){
        return "Student{name="+name+",ID="+ID+",age="+age+"}";
    }
}
