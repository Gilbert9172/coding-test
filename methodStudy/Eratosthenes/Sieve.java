package Eratosthenes;

public class Sieve {
    public static void main(String[] args) {
        int N = 26;
        primeNumbers(N);
    }

    public static void primeNumbers(int num) {

        int[] arr = new int[num+1];

        for (int i = 2; i <= num; i++) {
            arr[i] = i;
        }

        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt ; i++) {
            if (arr[i] == 0) {
                continue;
            }

            // i의 배수를 구한다.
            for (int j = i * i; j <= num; j += i) {
                arr[j] = 0;
            }
        }

        for (int primeNum : arr) {
            if (primeNum != 0) {
                System.out.print(primeNum + " ");
            }
        }
    }
}
