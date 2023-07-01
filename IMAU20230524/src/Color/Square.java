package Color;
public class Square extends GeometricObject implements Colorable {
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}