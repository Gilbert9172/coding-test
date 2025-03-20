package greedy.medium.quiz455;

public class RunSolve {
    public static void main(String[] args) {
        V1 v1 = new V1();
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
//        int[] g = {10, 9, 8, 7};
//        int[] s = {10, 9, 8, 7};
//        int[] g = {1 ,2 ,3};
//        int[] s = {3};
        int answer = v1.findContentChildren(g, s);
        System.out.println(answer);
    }
}
