package Color;

public class Main {
    public static void main(String[] args) {
        GeometricObject[] objects = new GeometricObject[5];
        objects[0] = new Square();
        objects[1] = new Square();
        objects[2] = new Square();
        objects[3] = new GeometricObject();
        objects[4] = new Square();
        for(GeometricObject a:objects){
            if(a instanceof Square){
                Colorable colorable = (Colorable) a;
                colorable.howToColor();
            }
            else
                System.out.println("error");
        }
    }
}

