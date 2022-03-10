package P1_march.reportResult;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> userIdMap = initUserIdMap(id_list);  //user - id(index)
        Map<Integer, List<Integer>> suspectIdReportedListMap = initSuspectIdCheckListMap(id_list);   //신고당한 유저(id) - 신고한 유저들의 List
        setReportToIdCheckListMap(report, userIdMap, suspectIdReportedListMap);

        return getPushMailNumPerUserArray(k, suspectIdReportedListMap);
    }

    private Map<String, Integer> initUserIdMap(String[] id_list) {
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String id : id_list) {
            map.put(id, index);
            index++;
        }
        return map;
    }

    private HashMap<Integer, List<Integer>> initSuspectIdCheckListMap(String[] id_list) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int numOfIds = id_list.length;

        int[] initNumArray = new int[numOfIds];

        for (int i = 0; i < numOfIds; i++) {
            List<Integer> checkList = Arrays.stream(initNumArray).boxed().collect(Collectors.toList());
            map.put(i, checkList);
        }

        return map;
    }

    private void setReportToIdCheckListMap(String[] report, Map<String, Integer> idIndexListMap, Map<Integer, List<Integer>> suspectIdCheckedListMap) {
        for (String contents : report) {
            String[] ids = contents.split(" ");
            String reporter = ids[0];
            String suspect = ids[1];

            int indexOfReporter = idIndexListMap.get(reporter); //신고한 유저의 index
            int indexOfSuspect = idIndexListMap.get(suspect);   //신고'된' 유저의 index

            //신고'된'유저를 '누가 신고하였는가?(신고한 유저)' 를 담는 list - 해당 리스트는 신고한 유저의 index 에 따라 넣는다.
            List<Integer> reportList = suspectIdCheckedListMap.get(indexOfSuspect);
            reportList.set(indexOfReporter, 1);
        }
    }

    private int[] getPushMailNumPerUserArray(int k, Map<Integer, List<Integer>> idCheckListMap) {
        int size = idCheckListMap.size();
        int[] pushMailNumPerUser = new int[size];

        idCheckListMap.forEach((indexOfId, reportedList) -> {
            int totalCheckNum = 0;

            int indexOfReportUser= 0;   //신고한 유저의 index
            int[] tempCheckedNumList = new int[size];
            for (Integer isReported : reportedList) {
                if (isReported == 1) {
                    totalCheckNum++;
                    tempCheckedNumList[indexOfReportUser] = 1;
                }
                indexOfReportUser++;
            }

            if (totalCheckNum >= k) {
                int indexOfUser = 0;
                for (int i : tempCheckedNumList) {
                    pushMailNumPerUser[indexOfUser] += i;
                    indexOfUser++;
                }
            }
        });

        return pushMailNumPerUser;
    }
}

public class GetReportResult {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] array = sol.solution(id_list, report, k);
        for (int arr : array) {
            System.out.print(arr + "\t");
        }
    }
}
