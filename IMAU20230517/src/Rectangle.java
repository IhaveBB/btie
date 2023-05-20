public class Rectangle extends Shape{
    double wide = 0;
    double length = 0;
    Rectangle(){}
    public void setRectangle(double length,double wide){
        this.length = length;
        this.wide = wide;
    }
    @Override
    public double getArea() {
        return length*wide;
    }
}
