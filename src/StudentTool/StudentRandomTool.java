package StudentTool;
import java.util.Random;

public class StudentRandomTool {
    private static Random rm = new Random();
    public static void getStudenTool(int n){
        for(int i = 0;i<n;i++){
        String name = StudentTool.nameIsTrue(nameRandom());
        int age = StudentTool.ageIsTrue(rm.nextInt(2)+17);
        int score = StudentTool.scoreIsTrue(rm.nextInt(451));
        StudentTool.addStudent(name, age, score);
        }
    }

    public static String nameRandom(){
        int nameRange = rm.nextInt(100);
        char[] name;
        if(nameRange<65){
            name = new char[3];
        }else if(nameRange<98){
            name = new char[2];
        }else{
            name = new char[4];
        }
        int range = 0x9FFF-0x4E00+1;
        for (int i = 0; i < name.length; i++) {
            int nameId = rm.nextInt(range);
            name[i]=(char)(0x4E00+nameId);
        }
        return String.valueOf(name);
    }
}
