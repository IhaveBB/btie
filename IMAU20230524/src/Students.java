public class Students implements Cloneable{
    String name;
    int sno;
    Birthday birth;

    public Students(String name, int sno, Birthday birth) {
        this.name = name;
        this.sno = sno;
        this.birth = birth;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Students s = (Students) super.clone();
        s.birth = (Birthday) s.birth.clone();
        return s;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", sno=" + sno +
                ", birth=" + birth +
                '}';
    }
}
