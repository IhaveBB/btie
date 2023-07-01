import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Students [] students = new Students[30];
        System.out.println("请输入您要登入成绩的学生姓名  学号  成绩");
        for(int i=0;i<students.length;i++){
            try{
                students[i]=new Students(sc.next(),sc.next(),sc.nextDouble());
            }catch (ScoreException e){
                System.out.println(e.getMessage());
            }
        }

    }
}

class ScoreException extends Exception {
    public ScoreException(String message){
        super(message);
    }
}

class Students{
    private String name;
    private double score;
    private String StudentNumber;
    public Students(String name, String StudentNumber, double score) throws ScoreException{
        this.name = name;
        this.StudentNumber = StudentNumber;
        this.score = score;
        if(this.score<0||this.score>100){
            throw new ScoreException("成绩非法");
        }
        else{
            System.out.println("输入成功");
        }
    }

}