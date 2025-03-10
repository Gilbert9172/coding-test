package array.easy.quiz1768;

/**
 * [ Constrains ]
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */


public class JavaSolution {

    public static void main(String[] args) {
        String s = mergeAlternately("abc", "zz");
        System.out.println(s);
    }

    public static String mergeAlternately(String word1, String word2) {
        int aPointer = 0;
        int bPointer = 0;
        int word1LastIdx = word1.length() - 1;
        int word2LastIdx = word2.length() - 1;

        StringBuilder sb = new StringBuilder();

        // End Condition : both pointer at last idx
        while (aPointer <= word1LastIdx || bPointer <= word2LastIdx) {
            if (aPointer <= word1LastIdx) {
                sb.append(word1.charAt(aPointer));
                aPointer++;
            }

            if (bPointer <= word2LastIdx) {
                sb.append(word2.charAt(bPointer));
                bPointer++;
            }
        }

        return sb.toString();
    }
}
