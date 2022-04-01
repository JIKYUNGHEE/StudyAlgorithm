package Practice.P1_march.findNumbers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] numbers) {
        Map<Integer, Boolean> numberMap = initNumberMap(numbers);
        int sumOfExceptNum = 0;
        for (int i = 0; i < 10; i++) {
            if (numberMap.containsKey(i)) {
                continue;
            }
            sumOfExceptNum += i;
        }
        return sumOfExceptNum;
    }

    private HashMap<Integer, Boolean> initNumberMap(int[] numbers) {
        HashMap<Integer, Boolean> numberMap = new HashMap<>();
        for (int number : numbers) {
            numberMap.put(number, true);
        }
        return numberMap;
    }
}

public class FindExceptNumbers {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        sol.solution(numbers);
    }
}