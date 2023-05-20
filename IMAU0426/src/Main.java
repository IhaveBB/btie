public class Main {
    public static void main(String[] args) {
        People p1=new People();
        p1.speakHello();
        p1.averageHeight();
        p1.averageWeight();
        System.out.println("================================================");
        Chinese c1=new Chinese();
        c1.chinaGongfu();
        c1.speakHello();
        c1.averageHeight();
        c1.averageWeight();
        System.out.println("================================================");
        American a1=new American();
        a1.speakHello();
        a1.averageHeight();
        a1.averageWeight();
        a1.americanBoxing();
        System.out.println("================================================");
        Beijingman b1=new Beijingman();
        b1.beijingOpera();
        b1.averageHeight();
        b1.averageWeight();
    }
}

class People{
    protected double height;
    protected double weight;
    public void speakHello() {
        System.out.println("yayaya");
    }
    public void averageHeight(){
        height=173;
        System.out.println("人的平均身高是"+height);
    }
    public void averageWeight(){
        weight=70;
        System.out.println("人的平均体重是"+weight);
    }
}

class Chinese extends People{
    public void chinaGongfu() {
        System.out.println("坐如钟，站如松，睡如弓");
    }
    public void speakHello(){
        System.out.println("你好");
    }
    public void averageHeight(){
        height=168.78;
        System.out.println("中国人的平均身高是"+height);
    }
    public void averageWeight(){
        weight=65;
        System.out.println("中国人的平均体重是"+weight);
    }
}

class American extends People{
    public void americanBoxing(){
        System.out.println("直拳、勾拳、组合拳");
    }
    public void speakHello(){
        System.out.println("how do you do");
    }
    public void averageHeight(){
        height=176;
        System.out.println("美国人的平均身高是"+height);
    }
    public void averageWeight(){
        weight=75;
        System.out.println("美国人人的平均体重是"+weight);
    }
}

class Beijingman extends Chinese{
    public void beijingOpera(){
        System.out.println("花脸、青衣、花旦和老生");
    }
    public void averageHeight(){
        height=172.5;
        System.out.println("北京人的平均身高是"+height);
    }
    public void averageWeight(){
        weight=70;
        System.out.println("北京人的平均体重是"+weight);
    }
}
