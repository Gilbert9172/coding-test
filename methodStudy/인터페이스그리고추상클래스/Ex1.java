package 인터페이스그리고추상클래스;

public class Ex1 extends AbstractEx1 implements Swimmable{
    @Override
    void wakeup() {
        super.wakeup();
    }

    @Override
    public void swim() {
        System.out.println("Ex1 swim");
    }

    @Override
    public void talk() {

    }
}
