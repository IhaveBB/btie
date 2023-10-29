package Circle2;

public class Circle {
    double radius;
    Circle(double radius){
        this.radius=radius;
    }

    double getArea() {
        return Math.PI*radius*radius;
    }
}
class MyCircle extends Circle implements Comparable{
    MyCircle(double radius){
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        MyCircle c2=(MyCircle)o;
        if(this.getArea()>c2.getArea()) {
            return (int)(this.getArea()-c2.getArea());
        } else if(this.getArea()==c2.getArea()) {
            return 0;
        } else {
            return (int)(this.getArea()-c2.getArea());
        }

    }
}