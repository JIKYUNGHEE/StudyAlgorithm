package RealTest.T1_march.showMetheCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bfs {

    private static final int TOP = 0;
    private static final int BOTTOM = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private static int n;
    private static int[][] map;
    private static int answer;

    public static void main(String[] args) throws IOException {
        //입력을 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer stringTokenizer;


        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        //게임을 시작한 뒤
        game(0);

        //answer 을 출력한다.
        System.out.println(answer);
    }

    public static void game(int cnt) {
        // 총 5번의 동작
        if (cnt == 5) {
            findMax();
            return;
        }

        // 백트레킹이 가능하도록 map 을 copy 배열에 복사해둔다.
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            game(cnt + 1);
            // 동작 후, 재귀가 끝났을 때, copy 배열의 값을 map 으로 불러와 기존 값을 복구한다.
            for (int j = 0; j < n; j++) {
                map[j] = copy[j].clone();
            }
        }

    }

    public static void move(int dir) {
        //dir 값에 따라 동작을 달리한다.
        //index 값을 넣을 위치
        //block 최근 블록의 수
        switch (dir) {
            case TOP:   //위
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < n; j++) {
                        if (map[j][i] != 0) {
                            if (block == map[j][i]) {
                                map[index - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case BOTTOM:    //아래
                for (int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for (int j = n - 1; j >= 0; j--) {
                        if (map[j][i] != 0) {
                            if (block == map[j][i]) {
                                map[index + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case LEFT:      //왼
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] != 0) {
                            if (block == map[i][j]) {
                                map[i][index - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case RIGHT:     //오
                for (int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for (int j = n - 1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            if (block == map[i][j]) {
                                map[i][index + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void findMax() {
        //map 을 순회하면서 가장 큰 수를 찾아낸다.
        for (int[] xys : map) {
            for (int xy : xys) {
                answer = Math.max(answer, xy);
            }
        }
    }
}