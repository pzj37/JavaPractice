import java.time.LocalDate;

public class StudentTool {
    public static Student addStudent(String name, int age) {
        isMax();
        return StudentMax.max[StudentMax.Now++]= new Student(nameIsTrue(name),ageIsTrue(age));
    }

    public static void deleteStudent(int ID){
        isMin();
        for(int i = 0;i < StudentMax.max.length;i++){
            Student student = StudentMax.max[i];
            if(student!=null&&student.getID()==ID){
                System.out.println("删除了"+ student);
                StudentMax.max[i] =null;
                for(int m = i;m<StudentMax.max.length-1;i++){
                    StudentMax.max[i]=StudentMax.max[i+1];
                }
                return;
            }
        }
        throw new RuntimeException("未找到ID："+ID);
    }

    public static Student find(int ID) {
        isMin();
        for(int i = 0;i<StudentMax.max.length;i++){
            Student student = StudentMax.max[i];
            if(student!=null&&student.getID()==ID){
                System.out.println(student);
                return student;
            }
        }
        throw new RuntimeException("没找到ID："+ID);
    }

    public static void find(String name,int age) {
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
        for (Student student :StudentMax.max) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    public static void isMin(){
        if(StudentMax.Now == 0){
            throw new RuntimeException("你还没有学生");
        }
    }
    public static void isMax(){
        if(StudentMax.Now==StudentMax.max.length){
            throw new RuntimeException("人满了");
        }
    }

    public static int ageIsTrue(int age) {
        if (age<0||age>30) {
            throw new RuntimeException("不可设置年龄："+age);
        }
        return age;
    }
    public static String nameIsTrue(String name) {
        if(name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            throw new RuntimeException("不可设置名字："+name);
        }
        return name;
    }
    public static int idIsTrue(int id){
        String now = Integer.toString(LocalDate.now().getYear());
        if(!(Integer.toString(id).matches(now+".*"))){
            throw new RuntimeException("错误ID："+id);
        }
        return id;
    }
}
