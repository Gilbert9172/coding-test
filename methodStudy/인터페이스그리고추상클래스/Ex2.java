package 인터페이스그리고추상클래스;

public class Ex2 extends AbstractEx2 implements Swimmable {
    @Override
    void cry() {
        super.cry();
    }

    @Override
    public void swim() {
        System.out.println("Ex2 swim");
    }

    @Override
    public void talk() {

    }
}
