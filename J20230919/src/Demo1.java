public class Demo1 {
    public static void main(String[] args) {
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1 == singletonLazy2);
        System.out.println(singletonLazy1.equals(singletonLazy2));
    }
}
