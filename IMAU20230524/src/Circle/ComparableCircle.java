package Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }
    @Override
    public int compareTo(ComparableCircle o) {
        if(getArea()> o.getArea()){
            return  1;
        }
        else if(getArea()<o.getArea()){
            return -1;
        }
        else if(getArea()==o.getArea()){
            return 0;
        }
        return 0;
    }


}
