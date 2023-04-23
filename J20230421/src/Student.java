public class Student {
    private String name;
    Course s1[]=new Course[20];
    int index=0;
    Student(String name){
        this.name=name;
    }

    public void select(String name,int bianhao) {
        s1[index]=new Course(name,bianhao);
        index++;
    }
    public void delete(int bianhao) {
        for(int i=0;i<index;i++) {
            assert s1 != null;
            if(bianhao==s1[i].getbianhao()) {
                s1[i]=null;
            }
        }
    }
    public void query() {
        for(int i=0;i<index;i++) {
            if(s1[i]!=null) {
                System.out.println(s1[i]);
            }
        }
    }
}