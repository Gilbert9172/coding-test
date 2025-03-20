package greedy.medium.quiz455;

import java.util.Arrays;

/**
 * [455. Assign Cookie](https://leetcode.com/problems/assign-cookies/description/)
 */
public class V1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
