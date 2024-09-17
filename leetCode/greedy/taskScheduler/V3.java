package greedy.taskScheduler;

public class V3 {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];

        for(char c: tasks)
            freqs[c - 'A']++;

        int maxFreq = 0;
        int maxCount = 0;
        for(int freq : freqs) {
            if(freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            }
            else if(freq == maxFreq) {
                maxCount++;
            }
        }
        int minIntervals = (maxFreq-1) * (n+1) + maxCount;
        return Math.max(minIntervals, tasks.length);
    }
}
