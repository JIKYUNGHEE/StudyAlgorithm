package T1_march.q1;

import java.util.*;



class Solution {
    class Coin {
        int index;
        int value;
        int cost;
        int count;

        public Coin(int index, int value, int cost) {
            this.index = index;
            this.value = value;
            this.cost = cost;
        }
    }

    public int solution(int money, int[] costs) {
        int[] values = {1, 5, 10, 50, 100, 500};
        List<Coin> coinList = initCoinList(values, costs);
//        List<Integer[]> candidateCaseList = getCandidateCaseList(money, coinList);
//        return getMinimumTotalCost(coinList, candidateCaseList);
        return 0;
    }

    private List<Coin> initCoinList(int[] value, int[] costs) {
        ArrayList<Coin> coinList = new ArrayList<>();
        int index = 0;
        for(int i=0; i<value.length; i++) {
            coinList.add(new Coin(index, value[index], costs[index]));
        }
        return coinList;
    }

    private int getMinimumTotalCost(List<Coin> costPerCoin, List<Integer[]> candidateCaseList) {
        int minimumTotalCost = Integer.MAX_VALUE;

        for (Integer[] integers : candidateCaseList) {
            int totalCost = 0;
            int index = 0;
            for (Integer integer : integers) {
                totalCost += costPerCoin.get(index).cost * integer;
                index++;
            }

            if (totalCost <= minimumTotalCost) {
                minimumTotalCost = totalCost;
            }
        }

        return minimumTotalCost;
    }

//    private ArrayList<Integer[]> getCandidateCaseList(int money, List<Coin> coins) {
//        Queue<Coin> coinQueue = new LinkedList<>();
//
//        int index = 0;
//        int remain = money;
//        coinQueue.add(coins.get(index));
//
//        ArrayList<List<Coin>> candidateCaseList = new ArrayList<>();
//
//        while (!coinQueue.isEmpty()) {
//            Coin coin = coinQueue.poll();
//            int countOfMaxCoin = remain / coin.value;
//            remain = remain % coin.value;
//
//            List<Coin> candidateCoinList = new ArrayList<>();
//
//            if(remain == 0) {
//                candidateCaseList.add(candidateCoinList);
//                continue;
//            }
//
//            if (remain != 0) {
//                index = (index == 5) ? 0 :index + 1;
//                coinQueue.add(new Coin(index, coins[index], countOfMaxCoin));
//            }
//        }
//
//        return candidateCaseList;
//    }
}


public class Q1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4578, new int[]{1, 4, 99, 35, 50, 1000}));
    }
}

