package level2;

import java.util.Arrays;
import java.util.Comparator;

public class quiz42746 {

    static Comparator<String> comparator = (o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);

    public static void main(String[] args) {

        int[] numbers = {3, 30, 34, 5, 9};

        // int[] -> String[]
        String[] strNumbers = Arrays.stream(numbers).boxed()
                                    .map(n -> String.valueOf(n))
                                    .toArray(String[]::new);

        Arrays.sort(strNumbers, comparator);

        for (String strNumber : strNumbers) {
            System.out.println(strNumber);
        }

    }
    /**
     * static Comparator<String> comparator = new Comparator<String>() {
     *         @Override
     *         public int compare(String o1, String o2) {
     *             return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
     *         }
     *     };
     */
}
