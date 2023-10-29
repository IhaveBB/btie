public class Demo1{
    public static void main(String[] args) {
        try {
            Tringle t1 = new Tringle(3, 4, 5);
            double perimeter = t1.getPerimeter();
            System.out.println("周长为：" + perimeter);
        } catch (TriangleException e) {
            System.out.println(e.getMessage());
        }

        try {
            Tringle t1 = new Tringle(1, 2, 3);
            double perimeter = t1.getPerimeter();
            System.out.println("周长为：" + perimeter);
        } catch (TriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}

class TriangleException extends Exception {
    public TriangleException(String message) {
        super(message);
    }
}

    class Tringle {
        int a;
        int b;
        int c;

        Tringle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getPerimeter() throws TriangleException {
            if (a + b <= c || a + c <= b || b + c <= a) {
                throw new TriangleException("不能构成三角形");
            } else {
                return a + b + c;
            }
        }
    }

