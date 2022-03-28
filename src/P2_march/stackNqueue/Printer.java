package P2_march.stackNqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int value = sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.print(value);
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int index = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int priority: priorities) {
            Pair pair = new Pair(index, priority);
            queue.add(pair);
            index++;
        }

        Arrays.sort(priorities);

        int sortIndex = priorities.length - 1;
        int order = 1;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int maxValue = priorities[sortIndex];
            if(pair.value == maxValue) {
                if(pair.index == location) {
                    return order;
                }

                sortIndex--;
                order++;
                continue;
            }

            queue.add(pair);
        }

        return 0;
    }

    class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
