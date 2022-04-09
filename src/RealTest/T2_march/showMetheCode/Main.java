package RealTest.T2_march.showMetheCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N;  //물약의 종류
    static List<Integer> originCostList; //물약의 가격 리스트
    static Map<Integer, List<WaterMedicine>> discountMap = new HashMap<>(); //물약의 종류에 따라 할인되는 물약 리스트

    public static void main(String[] args) throws Exception {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        originCostList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < N; i++) {
            int key = i + 1;
            List<WaterMedicine> discountListByKey = new ArrayList<>();
            int numOfDiscountType = Integer.parseInt(br.readLine());

            for (int j = 0; j < numOfDiscountType; j++) {
                String[] discountInfo = br.readLine().split(" ");
                int discountKey = Integer.parseInt(discountInfo[0]);
                int discountCost = Integer.parseInt(discountInfo[1]);
                discountListByKey.add(new WaterMedicine(discountKey, originCostList.get(discountKey - 1), discountCost));
            }

            Collections.sort(discountListByKey);

            discountMap.put(key, discountListByKey);
        }

        List<Integer> totalCostList = new ArrayList<>();
        int totalCost = 0;

        for (int key = 1; key <= N; key++) {
            int[] buyHistoryOfWaterMedicines = new int[4];
            int numOfDidBuy = 0;

            while (true) {
                //모든 물약을 샀으면
                if (numOfDidBuy == N) {
                    break;
                }

                //물약을 산다.
                int cost = originCostList.get(key - 1);
                buyHistoryOfWaterMedicines[key - 1] = cost;

                //해당 물약을 사면, 할인받을 수 있는 내역이 있는 지 확인한다.
                List<WaterMedicine> discountListByKey = discountMap.get(key);
                buyDiscountWaterMedicine(discountListByKey, buyHistoryOfWaterMedicines);//할인 받을 수 있는 것들을 모두 산다.

                if (numOfDidBuy != N) {  //할인을 받지 않은 물약들을 더한다.
                    for (int index = 0; index < buyHistoryOfWaterMedicines.length; index++) {
                        if (buyHistoryOfWaterMedicines[index] == 0) {
                            buyHistoryOfWaterMedicines[index] = originCostList.get(index);
                        }
                    }
                }

                for (int buyHistoryOfWaterMedicine : buyHistoryOfWaterMedicines) {
                    if(buyHistoryOfWaterMedicine > 0) {
                        numOfDidBuy++;
                    }
                }
            }

            //총 합계를 구한다.
            for (int buyHistory : buyHistoryOfWaterMedicines) {
                totalCost += buyHistory;
            }

            totalCostList.add(totalCost);
        }

        Collections.sort(totalCostList);

        System.out.println(totalCostList.get(0));
    }

    private static void buyDiscountWaterMedicine(List<WaterMedicine> discountListByKey, int[] buyHistoryOfWaterMedicines) {
        if (discountListByKey == null || discountListByKey.isEmpty()) {
            return;
        }

        //할인받고 산다. -> 앞에서 미리 정렬했으므로 0번째 인덱스에 있는 물약이 할인을 제일 많이 하는 것이다.
        WaterMedicine nextButWaterMedicine = discountListByKey.remove(0);
        int buyHistory = buyHistoryOfWaterMedicines[nextButWaterMedicine.key - 1];

        int cost;
        if(buyHistory == 0) {   //최초할인
            cost = (nextButWaterMedicine.defaultCost - nextButWaterMedicine.discount < 0) ? 1 : nextButWaterMedicine.defaultCost - nextButWaterMedicine.discount;
        } else {    //중복할인
            cost = (buyHistory - nextButWaterMedicine.discount < 0) ? 1 : buyHistory - nextButWaterMedicine.discount;
        }
        buyHistoryOfWaterMedicines[nextButWaterMedicine.key - 1] = cost;

        buyDiscountWaterMedicine(discountMap.get(nextButWaterMedicine.key), buyHistoryOfWaterMedicines);
    }

    private static class WaterMedicine implements Comparable<WaterMedicine> {
        int key;
        int defaultCost;
        int discount;

        public WaterMedicine(int key, int defaultCost, int discount) {
            this.key = key;
            this.defaultCost = defaultCost;
            this.discount = discount;
        }

        // 메서드를 호출하는 객체가 인자로 넘어온 객체보다 작을 경우에는 음수를 리턴하고, 크기가 동일하다면 0, 클 경우에는 양수를 리턴
        @Override
        public int compareTo(WaterMedicine o) {
            int finalCost = Math.max((defaultCost - discount), 1);
            int oFinalCost = Math.max((o.defaultCost - o.discount), 1);

            return oFinalCost - finalCost;
        }

        @Override
        public String toString() {
            return "WaterMedicine{" +
                    "key=" + key +
                    ", defaultCost=" + defaultCost +
                    ", discount=" + discount +
                    '}';
        }
    }
}