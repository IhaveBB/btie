package wages;

public class WeekWorker extends Employee{
    @Override
    public void earnings() {
        wage=52*780;
    }
    @Override
    public double getWage(){
        return wage;
    }
}
