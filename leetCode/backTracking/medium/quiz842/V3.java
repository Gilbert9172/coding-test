package backTracking.medium.quiz842;

import java.util.ArrayList;
import java.util.List;

// 제일 빠른 코드
// [LeetCode#842] Split Array into Fibonacci Sequence
public class V3 {

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> bucket = new ArrayList<>();
        backTracking(num.toCharArray(), bucket, 0);
        return bucket;
    }

    public boolean backTracking(char[] digit, List<Integer> list, int index) {
        if (index == digit.length && list.size() >= 3) {
            return true;
        }
        for (int i = index; i < digit.length; i++) {
            if (digit[index] == '0' && i > index) {
                break;
            }
            long num = subDigit(digit, index, i + 1);
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                if (backTracking(digit, list, i + 1))
                    return true;
                list.removeLast();
            }
        }
        return false;
    }

    // substring을 사용하지 않고 배열을 사용
    private long subDigit(char[] digits, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digits[i] - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        V3 v3 = new V3();
        List<Integer> answer = v3.splitIntoFibonacci("1101111");
        for (Integer element : answer) {
            System.out.println(element);
        }
    }
}
