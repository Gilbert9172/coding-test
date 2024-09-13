package level1;

public class 소수찾기 {

    public static void main(String[] args) {
        int[] prime = isPrime(10);
        int count = 0;
        for (int i : prime) {
            if (i != 0) {
                count ++;
            }
        }
        System.out.println(count);

    }


    private static int[] isPrime(int num) {

        int[] arr = new int[num + 1];

        for (int i = 2; i <= num; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {

            if (arr[i] == 0) {
                continue;
            }

            for (int j = i * i; j <= num; j += i) {
                arr[j] = 0;
            }
        }
        return arr;
    }
}
