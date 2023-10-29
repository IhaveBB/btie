public class sumArea {
    public static void main(String[] args) {

        GeometricObject[] list = new GeometricObject[5];
        list[0] = new Circle1(5);
        list[1] = new Circle1(10);
        list[2] = new Rectangle1(10, 10);
        list[3] = new Rectangle1(2, 5);
        System.out.println(sumArea(list));
    }

    public static double sumArea(GeometricObject[] list) {
        double sum = 0;
        for (int i = 0; i < list.length-1; i++) {
            sum = sum + list[i].getArea();
        }
        return sum;
    }
}




abstract class GeometricObject{
    abstract public double getArea();
}

class Circle1 extends GeometricObject{
    double radius = 0;
    Circle1(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}

class Rectangle1 extends GeometricObject{
    double wide = 0;
    double length = 0;
    Rectangle1(double length,double wide){
        this.length = length;
        this.wide = wide;
    }
    @Override
    public double getArea() {
        return length*wide;
    }
}



