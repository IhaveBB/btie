package wages;

public class MonthWorker extends Employee{
    @Override
    public void earnings() {
        wage=12*2300;
    }
    @Override
    public double getWage(){
        return wage;
    }
}
