
public class Birthday implements Cloneable{
    int year;
    int month;
    int day;
    Birthday(int year,int month,int day){
        this.year=year;
        this.day=day;
        this.month=month;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Birthday)super.clone();
    }
    @Override
    public String toString() {
        return "Birthday{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
