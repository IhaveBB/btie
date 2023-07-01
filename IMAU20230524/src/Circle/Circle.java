package Circle;

public class Circle{
    double radius;
    double x;
    double y;

    public double getArea() {
        return Math.PI*radius*radius;
    }

    public Circle(double x, double y, double radius) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    public Circle(){}

    @Override
    public String toString() {
        return "圆心"+"("+x+","+y+")"+"半径"+radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }


}
