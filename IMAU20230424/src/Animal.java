public class Animal {
    int age;
    char gender;
    String name;
    public void setName(String name) {
        this.name = name;
    }
    public void eat(){
        System.out.println("在吃饭");
    }
    public void sleep(){
        System.out.println("在睡觉");
    }
    public void drink(){
        System.out.println("在喝水");
    }
}
