package P1_march;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        //0. init rankMap && isWinLottoMap
        Map<Integer, Integer> rankMap = initRankMap();

        int countOfZero = getCountOfZero(lottos);                           //아래 두 코드를 합치려면 어떻게 해야 할까?
        Map<Integer, Boolean> isWinLottoMap = initIsWinLottoMap(lottos);

        //2. count number of Win
        int numOfWin = 0;
        for (int win_num : win_nums) {
            if (isWinLottoMap.containsKey(win_num)) {
                numOfWin++;
            }
        }

        answer[0] = rankMap.get(numOfWin + countOfZero);
        answer[1] = rankMap.get(numOfWin);

        return answer;
    }

    private HashMap<Integer, Integer> initRankMap() {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int maxWinCountNum = 6;

        rankMap.put(0, maxWinCountNum);

        for (int countOfWin = 1; countOfWin <= 6; countOfWin++) {
            rankMap.put(countOfWin, maxWinCountNum - countOfWin + 1);
        }
        return rankMap;
    }

    private int getCountOfZero(int[] lottos) {
        int countOfZero = 0;

        for (int lotto : lottos) {
            if(lotto == 0) {
                countOfZero++;
            }
        }
        return countOfZero;
    }

    private HashMap<Integer, Boolean> initIsWinLottoMap(int[] lottos) {
        HashMap<Integer, Boolean> isWinLottoMap = new HashMap<>();

        for (int lotto : lottos) {
            if(lotto == 0) {
               continue;
            }

            isWinLottoMap.put(lotto, false);
        }
        return isWinLottoMap;
    }
}

public class Lottos {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        sol.solution(lottos, win_nums);
    }
}