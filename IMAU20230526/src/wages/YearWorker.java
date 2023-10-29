package wages;

public class YearWorker extends Employee{
    @Override
    public void earnings() {
        wage=12000;
    }
    @Override
    public double getWage(){
        return wage;
    }
}
