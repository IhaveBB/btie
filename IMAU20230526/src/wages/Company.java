package wages;

public class Company {
    double sum;
    Employee[] employee;

    public Company(Employee[] employees) {
        this.employee = employees;
    }
    public double salariesPay() {
        sum = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                employee[i].earnings();
                sum = sum + employee[i].getWage();
            }
        }
        return sum;
    }
}
