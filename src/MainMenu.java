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
                    Student.showAllStudents();
                }
                case "0"->{
                    return;
                }
                default -> {
                    System.out.println("错误值："+open_0);
                }
            }
        }
    }
    private static void addStudent(){
        System.out.println("请输入名字：");
        String name = sr.next();
        if(name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            System.out.println("不可设置名字："+name);
            return;
        }
        System.out.println("请输入年龄：");
        String stringAge = sr.next();
        if(!(stringAge.matches("[0-9]+"))){
            System.out.println("不可设置年龄："+stringAge);
            return;
        }
        int age = Integer.valueOf(stringAge);
        if(Student.addStudent(name,age)==null){
            return;
        }
        System.out.println("添加完成");
    }
    private static void deleteStudent(){
        System.out.println("请输入ID：");
        String stringID = sr.next();
        if(!(stringID.matches("[0-9]+"))){
            System.out.println("错误ID："+stringID);
            return;
        }
        int ID = Integer.valueOf(stringID);
        if(Student.deleteStudent(ID)){
            System.out.println("删除成功");
            return;
        }
        System.out.println("未找到ID:"+Student.toString(ID));
    }
    private static void setStudent(){
        System.out.println("请输入ID");
        String stringID = sr.next();
        if(!(stringID.matches("[0-9]+"))){
            System.out.println("错误ID："+stringID);
            return;
        }
        int ID = Integer.valueOf(stringID);
        Student student = Student.getStudent(ID);
        if(student==null){
            System.out.println("未找到ID:"+Student.toString(ID));
            return;
        }
        System.out.println("请输入名字：");
        String name = sr.next();
        if(name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            System.out.println("不可设置名字："+name);
            return;
        }
        student.setName(name);
        System.out.println("请输入年龄：");
        String stringAge = sr.next();
        if(!(stringAge.matches("[0-9]+"))){
            System.out.println("不可设置年龄："+stringAge);
            return;
        }
        int age = Integer.valueOf(stringAge);
        student.setAge(age);
        System.out.println("设置完成："+student.toString());
    }
    private static void findStudent(){
        System.out.println("请输入名字：");
        String name = sr.next();
        if(name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            System.out.println("不可设置名字："+name);
            return;
        }
        System.out.println("请输入年龄：");
        String stringAge = sr.next();
        if(!(stringAge.matches("[0-9]+"))){
            System.out.println("不可设置年龄："+stringAge);
            return;
        }
        int age = Integer.valueOf(stringAge);
        Student.find(name,age);
    }
}
