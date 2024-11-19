package backTracking.easy.quiz401;

import java.util.ArrayList;
import java.util.List;

public class V2 {

    List<String> ans = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        String time = "";
        int arr[] = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        findTime(arr, time, turnedOn, 0, 0, 0);
        return ans;
    }

    public void findTime(int[] arr, String time, int turnedOn, int startIdx, int hours, int mins) {
        if (turnedOn == 0) {
            if (hours > 11 || mins > 59) {
                return;
            }
            time = hours + ":" + (mins < 10 ? "0" + mins : mins);
            ans.add(time);
            return;
        }
        for (int i = startIdx; i < arr.length; i++) {
            if (i < 4) {
                hours += arr[i];
            } else {
                mins += arr[i];
            }

            findTime(arr, time, turnedOn - 1, i + 1, hours, mins);

            if (i < 4) {
                hours -= arr[i];
            } else {
                mins -= arr[i];
            }
        }
    }

    public static void main(String[] args) {
        V2 v2 = new V2();
        List<String> strings = v2.readBinaryWatch(9);
        System.out.println(strings.size());
    }
}
