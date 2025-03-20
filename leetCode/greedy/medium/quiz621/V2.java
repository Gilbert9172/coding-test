package greedy.medium.quiz621;

import java.util.Arrays;

public class V2 {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }
        Arrays.sort(arr);

        int maxFrequency = arr[25] - 1;
        int idle = maxFrequency * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxFrequency, arr[i]);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }
}
