package Thread;

public class ex1 {

    public static void main(String[] args) {
        ThreadEx1 t1 = new ThreadEx1();

        Runnable r = new ThreadEx2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }

}

class ThreadEx1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(0);
        }
    }
}

class ThreadEx2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(1);
        }
    }
}
