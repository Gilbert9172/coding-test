package Thread;

public class ex2 {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
        System.out.println("메인 스레드 종료");
    }

}

class Thread1 extends Thread {

    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}