package Recursive;

public class RecursiveExam01 {

    static int count = 0;

    public static void main(String[] args) {
        recursive(count);
    }

    public static void recursive(int count) {
        if (count == 5) return;
        recursive(count + 1);
        System.out.println(count + "번째");
    }
}
