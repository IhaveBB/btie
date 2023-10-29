package wages;

public abstract class Employee {
    double wage = 0;

    public abstract void earnings();

    public double getWage() {
        return wage;
    }
}
