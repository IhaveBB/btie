public class Circle extends Shape{
    double radius = 0;
    Circle(){
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}
