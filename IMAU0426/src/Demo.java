public class Demo {
    public static void main(String[] args) {
        Person p1=new Person("张三","呼和浩特","15510810888","hello@out.com");
        Student s1=new Student("李四","呼和浩特","15510810888","hello@out.com","一班");
        Employee e1=new Employee("张三","呼和浩特","15510810888","hello@out.com",20000);
        System.out.println(p1.toString());
        System.out.println(s1.toString());
        System.out.println(e1.toString());
    }
}
class Person{
    String name;
    String site;
    String phoneNumber;
    String email;
    public Person(String name, String site, String phoneNumber, String email) {
        this.name = name;
        this.site = site;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String toString(){
        return "姓名"+name+" "+"住址"+site+" "+"手机号"+phoneNumber+" "+"电子邮件"+email;
    }
}
class Student extends Person{
    String banji;
    public Student(String name, String site, String phoneNumber, String email,String banji) {
        super(name, site, phoneNumber, email);
        this.banji = banji;
    }
    public String toString(){
        return super.toString()+" "+"班级"+banji;
    }
}
class Employee extends Person{
    int wage;
    public Employee(String name, String site, String phoneNumber, String email,int wage) {
        super(name, site, phoneNumber, email);
        this.wage = wage;
    }
    public String toString(){
        return super.toString()+" "+"薪资"+wage;
    }
}
