package C1_SK_0312.Q1;

import java.util.HashMap;

public class Question01 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int money = 4578;
        int[] costs = {1, 4, 99, 35, 50, 1000};
        sol.solution(money, costs);
    }
}

class Solution {
    //생산단가 map 을 만든다.
    //money 를 만드는 경우의 수를 구한다.
    //각 경우의 비용을 구한다.
    //정렬한다. -> 최소값 return
    public int solution(int money, int[] costs) {
        HashMap<Integer, Integer> costMap = initCostMap(costs);
        
//        List<String> allCases = getAllCases(money);
        
        return 0;
    }

//    private List<String> getAllCases(int money) {
//    }

    private HashMap<Integer, Integer> initCostMap(int[] costs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] coin = {1, 5, 10, 50, 100, 500};
        int index = 0;
        for (int cost : costs) {
            map.put(coin[index], cost);
            index++;
        }
        
        return map;
    }
}
