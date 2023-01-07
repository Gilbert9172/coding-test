public class Child extends Parent {

    public void test1() {
        System.out.println("child");
    }

    public static void main(String[] args) {
        Child childe = new Child();
        childe.test1();
    }

}
