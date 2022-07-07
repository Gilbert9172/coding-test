package levelOne;

/**
 * 2021 KAKAO BLIND RECRUITMENT
 * 신규 아이디 추천(Lv.1)
 */
public class quiz02 {

    public static void main(String[] args) {

        String new_id = "...!@BaT#*..y.abcdefghijklm";

        String lowerCaseId = upperCaseToLowerCase(new_id);
        String noSpecialLetters = removeSpecialLetters(lowerCaseId);
        String noDuplicatedDot = removeContinuousDot(noSpecialLetters);
        String noEndPointDot = removeEndpointDot(noDuplicatedDot);
        String validatedStr = validateEmpty(noEndPointDot);
        String answer = validateLength(validatedStr);

        System.out.println("answer = " + answer);
    }

    //1. 대문자 -> 소문자
    private static String upperCaseToLowerCase(String id) {
        String lowerCaseId = id.toLowerCase();
        return lowerCaseId;
    }

    //2. 숫자, -,_,. 를 제외한 특수문자 제거
    private static String removeSpecialLetters(String id) {
        String specialLetters = "[^0-9a-z\\-\\_\\.]";
        id = id.replaceAll(specialLetters, "");
        return id;
    }

    //3. 마침표(.)가 두번 이상 연속된 부분을 하나의 마침표로
    private static String removeContinuousDot(String id) {
        String specialLetters = "[.]+";
        id = id.replaceAll(specialLetters, ".");
        return id;
    }

    //4. 마침표(.)가 처음이나 끝에 위치한다면 제거
    private static String removeEndpointDot(String id) {

        String a = String.valueOf(id.charAt(0));
        String b = String.valueOf(id.charAt(id.length()-1));

        if (id.length() == 1 && ".".equals(a)) {
            id = id.substring(1);
            return id;
        } else {

            if (".".equals(a)) {
                id = id.substring(1);
            }

            if (".".equals(b)) {
                id = id.substring(0, id.length() - 1);
            }
        }
        return id;
    }

    //5. 빈 문자열이라면 "a"를 대입
    private static String validateEmpty (String id) {
        if (id.length() == 0 || " ".equals(id)) {
            id = "a";
        }
        return id;
    }

    //6. 길이가 15이상일 경우 그 뒤 제거, 만약 제거 후 마침표(.)가 끝에 있다면 마침표(.)제거
    //7. 길이가 2자 이하면 마지막 문자를 길이가 3이 될 때까지 반복
    private static String validateLength(String id) {
        if (id.length() >= 15) {
            String lastLetter = String.valueOf(id.charAt(id.length()-1));
            if (".".equals(lastLetter)) {
                id = id.substring(0, id.length() - 1);
            } else {
                id = removeEndpointDot(id.substring(0, 15));
            }
        } else if (id.length() < 3) {
            while (id.length() < 3) {
                id += id.substring(id.length()-1);
            }
        }
        return id;
    }
}
