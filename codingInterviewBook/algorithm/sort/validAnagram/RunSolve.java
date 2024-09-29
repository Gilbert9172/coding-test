package algorithm.sort.validAnagram;

public class RunSolve {
    public static void main(String[] args) {
        V3 solution = new V3();
        String s = "nagaram";
        String t = "anagramm";
        boolean answer = solution.isAnagram(s, t);
        System.out.println(answer);
    }
}
