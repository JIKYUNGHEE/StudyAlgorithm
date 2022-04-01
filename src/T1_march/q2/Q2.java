package T1_march.q2;


//class Solution {
//    public int[][] solution(int n, boolean clockwise) {
//        int[] dy = {1, 0, -1, 0};
//        int[] dx = {0, 1, 0, -1};
//
//        int[][] answer = new int[n][n];
//
//        int startX = 0;
//        int startY = 0;
//
////        int finishX = (n % 2 ==0) ? (n-1)/2 : ();
//
//        int index = 0;
//        int numOfMove = 0;
//        while(true) {
////            if(startX == finishX && startY == finishY) {
////                break;
////            }
//
//            answer[startX][startY] = numOfMove;
//            if(clockwise) {
//                startX = dx[index];
//                startY = dy[index];
//
//                numOfMove++;
//            }
//        }
//
//
//        return answer;
//    }
//
//    private void move(boolean clockwise) {
//        if(clockwise) {
//            moveClockWise();
//        }
////        else {
////            moveReverseClockWise();
////        }
//    }
//
//    private void moveClockWise() {
//
//    }
//}
//
//public class Q2 {
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int[][] answer = sol.solution(5, true);
//
//        for (int[] ints : answer) {
//            for (int anInt : ints) {
//                System.out.print(anInt+"\n");
//            }
//            System.out.println();
//        }
//    }
//}
