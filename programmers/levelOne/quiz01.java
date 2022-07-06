package levelOne;

import java.util.*;

/**
 * 2022 KAKAO BLIND RECRUITMENT
 * 신고 결과 받기(Lv.1)
 */
public class quiz01 {
    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};

        int[] answer = new int[id_list.length];
        int k = 2;

        // 1. 중복 제거
        Set<String> reportSet = new HashSet<>();
        for (String reportData : report) {
            reportSet.add(reportData);
        }

        // 2. {신고 당한 사람 : [신고한 사람들]
        Map<String, List<String>> reporterReporteeMap = new HashMap<>();
        for (String name : reportSet) {

            String reporter = name.split(" ")[0];
            String reportee = name.split(" ")[1];

            List<String> reporterList = reporterReporteeMap.getOrDefault(reportee, null);
            if (reporterList == null) {
                reporterList = new ArrayList<>();
            }

            reporterList.add(reporter);
            reporterReporteeMap.put(reportee, reporterList);
        }
        System.out.println("reporterReporteeMap = " + reporterReporteeMap);

        // 3. 신고자를 신고한 사람한테 보내야하는 매일 수
        Map<String, Integer> sendEmail = new HashMap<>();
        for (List<String> reportList : reporterReporteeMap.values()) {
            if (reportList.size() >= k) {
                for (String reporter : reportList) {
                    sendEmail.put(reporter, sendEmail.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        System.out.println(sendEmail);

        //4. 마무리
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = sendEmail.getOrDefault(id_list[i], 0);
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
