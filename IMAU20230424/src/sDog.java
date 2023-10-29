public class sDog extends Dog{
    public void getsName(String name){
        this.name=name;
    }
    public void getDName(String name){
        super.name=name;
    }
    public void returnName(){
        System.out.println(super.name);
    }
    public void returnsName(){
        System.out.println(super.name);
    }
}
