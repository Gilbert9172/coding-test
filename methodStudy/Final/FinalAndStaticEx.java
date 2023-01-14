package Final;

public class FinalAndStaticEx {

    public static void main(String[] args) {
        A a = new A(55);
        System.out.println(a.val + "<>" + a.val2);

        A a1 = new A(66);
        System.out.println(a1.val + "<>" + a1.val2);

        B b = new B();
        b.print();
    }



}

/**
 * final 키워드는 객체마다 값이 변경될 수 있다.<br>
 * 인스턴스 변수를 미리 초기화 할 수 있고, 나중에 값을 할당할 수도 있다.<br>
 * 만약 <span style="color:white">public final int val = 10;</span>  와 같이 값이 초기화가 된 상태에서<br>
 * 값을 변경하려고 한다면 에러가 발생한다.
 */
class A {
    public final int val = 10;
    public final int val2;

    public A(int val2) {
        this.val2 = val2;
    }
}

/**
 * static final의 경우 변하지 않는 수(상수)이다.
 */
class B {
    public static final int b = 10;

    public void print() {
        System.out.println(b);
    }
}