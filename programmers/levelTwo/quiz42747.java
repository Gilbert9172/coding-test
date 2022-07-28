package levelTwo;

import java.util.*;
import java.util.stream.Stream;

public class quiz42747 {

    public static void main(String[] args) {

        List<Integer> lst = new ArrayList<>();

        int[] citations = {3, 0, 6, 1, 5};

        int maxVal = Arrays.stream(citations).max().getAsInt();

        for (int h = 0; h <= maxVal; h++) {
            int more = 0;
            int less = 0;
            for (int i = 0; i < citations.length; i++) {
                if (h <= citations[i]) {
                    more ++;
                }
                else if (citations[i] <= h) {
                    less++;
                }
            }
            if (more >= h && less <= h) {
                lst.add(h);
            }
        }

        Collections.sort(lst, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int answer = Integer.parseInt(lst.get(0).toString());
        System.out.println("answer = " + answer);
    }
}

/*
*class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
* */