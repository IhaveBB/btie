public class Course {
    private String name;
    private int bianhao ;
    Course(String name,int bianhao){
        this.name=name;
        this.bianhao=bianhao;
    }
    @Override
    public String toString(){
        return "姓名"+name+",编号"+bianhao;
    }
    public int getbianhao() {
        return bianhao;
    }

}