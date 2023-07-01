public class Main {
    public static void main(String[] args) throws MyArrayIndexOutOfBoundsException {
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("================================");
        try {
            test(number, 10);
        } catch (MyArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
        }
        System.out.println("================================");
        try {
            test(number, 5);
        } catch (MyArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
        }
        System.out.println("================================");
        try {
            test(number, 10);
        } catch (MyArrayIndexOutOfBoundsException e) {
            MyArrayIndexOutOfBoundsException newException = new MyArrayIndexOutOfBoundsException(e.getMessage());
            throw newException;
        }
    }

    public static void test(int[] number, int i) throws MyArrayIndexOutOfBoundsException {
        if (i >= number.length || i < 0) {
            throw new MyArrayIndexOutOfBoundsException("数组越界");
        } else {
            System.out.println(number[i]);
        }
    }
}

class MyArrayIndexOutOfBoundsException extends Exception {
    public MyArrayIndexOutOfBoundsException(String message) {
        super(message);
    }
}
