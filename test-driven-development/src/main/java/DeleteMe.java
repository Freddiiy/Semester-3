public class DeleteMe {
    public String sayHello() {
        return "Hello";
    }

    public static void main(String[] args) {
        DeleteMe deleteMe = new DeleteMe();
        String result = deleteMe.sayHello();
        System.out.println(result);
    }
}
