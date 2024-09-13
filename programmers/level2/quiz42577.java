package level2;

import java.util.HashMap;

/**
 * 전화목록 번호 (해시)
 * 적힌 번호 중, 한 번호가 다른 번호의 접두어인 경우를 확인.
 */
public class quiz42577 {
    static Boolean answer = true;

    /* Sort
    public static void main(String[] args) {
        String[] phone_book = {"99819","9214145","124155","2377883","998"};
        // 1. phoneBook을 Sorting 한다.
        Arrays.sort(phone_book);

        // 2. 1중 Loop을 돌며 앞 번호가 뒷 번호의 접두어인지 확인한다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
            }
        }

        // 3. 여기까지 오면 접두어가 없다는 것이다.
        System.out.println(answer);
    }
    */

    // Hash
    public static void main(String[] args) {

        String[] phone_book = {"99819","9214145","124155","2377883","998"};

        // 1. HashMap을 선언한다.
        HashMap<String, Integer> map = new HashMap<>();

        // 2. 모든 전화번호를 HashMap에 넣는다.
        for (String phoneNum : phone_book) {
            map.put(phoneNum, 1);
        }

        // 3. 모든 전화번호의 subString이 HashMap에 존재하는지 확인한다.
        for (String phoneNum : map.keySet()) {
            for (int i = 0; i < phoneNum.length(); i++) {
                if (map.containsKey(phoneNum.substring(0, i))) {
                    answer = false;
                }
            }
        }
        System.out.println(answer);
    }
}
