public class Student{
    private static int IdToscore;
    private int ID;
    private String name;
    private int age;

    public Student(String name,int age){
        this.ID = 20260000+IdToscore;
        this.name = name;
        this.age = age;
        IdToscore++;
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
    public static String toString(String name){
        return "Student{name="+name+"}";
    }
    public static String toString(String name,int age){
        return "Student{name="+name+",age="+age+"}";
    }
    public static String toString(int ID){
        return "Student{ID="+ID+"}";
    }

}
