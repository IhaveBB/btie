public class Main {
    public static void main(String[] args) {
        Fan u1=new Fan();
        u1.setSpeed(Fan.FAST);
        u1.setRadius(10);
        u1.setColor("yellow");
        u1.setOn("on");
        System.out.println(u1.toString());

        Fan u2=new Fan();
        u2.setSpeed(Fan.MEDIUM);
        u2.setRadius(5);
        u2.setColor("blue");
        u2.setOn("off");
        System.out.println(u2.toString());

        Fan u3=new Fan();
        System.out.println(u3.toString());
    }
}