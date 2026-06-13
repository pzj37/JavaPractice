public class Student{
    private static Student[] student= new Student[100];
    private int ID;
    private String name;
    private int age;
    private static boolean peopleismace;

    private Student(String name,int age){
        for(int i = 0;i< student.length;i++) {
            if(student[i]==null) {
                this.ID = Integer.parseInt("2026" + Integer.toString(i));
                setName(name);
                setAge(age);
                student[i] = this;
                return;
            }
        }
        peopleismace = true;
    }

    public static Student getStudent(int ID) {
        for (Student student : student) {
            if (student!= null && student.ID == ID) {
                System.out.println(student.toString());
                return student;
            }
        }
        return null;
    }

    public static Student addStudent(String name, int age) {
        if (name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            System.out.println("不可设置名字："+name);
            return null;
        }
        if(age<0||age>30) {
            System.out.println("不可设置年龄："+age);
            return null;
        }
        if(peopleismace){
            System.out.println("人满了");
            return null;
        }
        return new Student(name,age);
    }

    public static boolean deleteStudent(int ID){
        for(int i = 0;i < student.length;i++){
            if(student[i]!=null&&student[i].ID==ID){
                System.out.println("删除了"+student[i].toString());
                student[i]=null;
                return true;
            }
        }
        System.out.println("未找到ID："+toString(ID));
        return false;
    }

    public void setStudent(String name,int age){
        setName(name);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if (age<0||age>30) {
            System.out.println("不可设置年龄："+age);
            return false;
        }
        this.age = age;
        return true;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            System.out.println("不可设置名字："+name);
            return false;
        }
        this.name = name;
        return true;
    }

    public static Student find(int ID) {
        for(int i = 0;i<student.length;i++){
            if(student[i]!=null&&student[i].ID==ID){
                System.out.println(student[i].toString());
                return student[i];
            }
        }
        System.out.println("没找到ID："+toString(ID));
        return null;
    }

    public static void find(String name) {
        boolean isfind = false;
        for (Student student: student) {
            if (student != null && student.name.equals(name)) {
                System.out.println(student.toString());
                isfind = true;
            }
        }
        if(!isfind){
            System.out.println("没找到名字："+toString(name));
        }
    }
    public static void find(String name,int age) {
        boolean isfind = false;
        for(Student student:student){
            if(student!=null&&student.name.equals(name)&&student.age==age){
                System.out.println(student.toString());
                isfind = true;
            }
        }
        if(!isfind){
            System.out.println("没找到学生："+toString(name,age));
        }
    }
    public static void showAllStudents(){
        System.out.println("全部学生：");
        boolean isfind = false;
        for (int i = 0;i<student.length;i++){
            if(student[i]!=null){
                System.out.println(student[i].toString());
                isfind = true;
            }
        }
        if(!isfind){
            System.out.println("你还没有学生");
        }
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
