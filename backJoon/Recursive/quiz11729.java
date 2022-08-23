package Recursive;

/**
 * 규칙
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 */

public class quiz11729 {

    public static void main(String[] args) {
        hanoi(5, 1, 2, 3);
    }

    public static void hanoi(int n, int from, int by, int to) {

        if (n == 1) {
            move(from, to);
            return;
        }

        hanoi(n - 1, from, to, by);
        move(from, to);
        hanoi(n - 1, by, from, to);
    }

    public static void move(int from, int to) {
        System.out.println(from + " to " + to);
    }
}
