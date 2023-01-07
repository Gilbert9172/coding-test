package 문자열더하기;

public class MonitorCount {

    public static synchronized void foo1() {};
    public synchronized void foo2() {};
    public void foo3() {
        synchronized (this) {
            System.out.println(this);
        }
    }
    public void foo4() {
        synchronized (getClass()) {
            System.out.println(getClass());
        }
    }
    public void foo5() {
        synchronized (new Object()) {
            System.out.println(new Object());
        }
    }
    public void foo6() {
        synchronized (new Object()) {
            System.out.println(new Object());
        }
    }

    public static void main(String[] args) {
        MonitorCount mc = new MonitorCount();
        mc.foo2();
        mc.foo3();
        mc.foo4();
        mc.foo5();
        mc.foo6();
    }
}
