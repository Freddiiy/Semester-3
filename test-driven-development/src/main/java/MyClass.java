public class MyClass {
    public String hello() {
        return "Hello";
    }

    public static void main(String[] args) {
        MyClass instance = new MyClass();
        String result = instance.hello();

        System.out.println(result);
    }
}
