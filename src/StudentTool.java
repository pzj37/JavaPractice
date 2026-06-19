public class StudentTool {
    public static Student getStudent(int ID) {
        for (Student student :StudentMax.max) {
            if (student!= null && student.getID() == ID) {
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
        if(StudentMax.Now==StudentMax.max.length){
            System.out.println("人满了");
            return null;
        }
        return StudentMax.max[StudentMax.Now]= new Student(name,age){
            {
                StudentMax.Now++;
            }
        };
    }

    public static boolean deleteStudent(int ID){
        for(int i = 0;i < StudentMax.max.length;i++){
            Student student = StudentMax.max[i];
            if(student!=null&&student.getID()==ID){
                System.out.println("删除了"+ student);
                StudentMax.max[i] =null;
                int j = i-1;
                for(int m = j;j<StudentMax.max.length;i++){
                    StudentMax.max[i]=StudentMax.max[i+1];
                }
                return true;
            }
        }
        System.out.println("未找到ID："+ID);
        return false;
    }

    public void setStudent(String name,int age){
        setName(name);
        setAge(age);
    }

    public int setAge(int age) {
        if (age<0||age>30) {
            System.out.println("不可设置年龄："+age);
            return -1;
        }
        return age;
    }

    public String setName(String name) {
        if(name==null||name.isEmpty()||!(name.matches("[\u4e00-\u9fa5]{1,6}"))){
            System.out.println("不可设置名字："+name);
            return null;
        }
        return name;
    }

    public static Student find(int ID) {
        for(int i = 0;i<StudentMax.max.length;i++){
            Student student = StudentMax.max[i];
            if(student!=null&&student.getID()==ID){
                System.out.println(student);
                return student;
            }
        }
        System.out.println("没找到ID："+ID);
        return null;
    }

    public static void find(String name,int age) {
        for(Student student:StudentMax.max){
            if(student!=null&&student.getName().equals(name)&&student.getAge()==age){
                System.out.println(student);
            }
        }
    }
    public static void showAllStudents(){
        System.out.println("全部学生：");
        for (Student student :StudentMax.max) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }
}
