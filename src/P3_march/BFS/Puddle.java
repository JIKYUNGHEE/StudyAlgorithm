package P3_march.BFS;

class Puddle {
    int[][] d;

    public int solution(int m, int n, int[][] puddles) {
        d = new int[m][n];
        d[0][0] = 1;

        //웅덩이 초기화
        for (int[] pud : puddles) {
            int x = pud[0] - 1;
            int y = pud[1] - 1;
            d[x][y] = -1;
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (d[x][y] == -1) {
                    d[x][y] = 0;
                } else {
                    if (x == 0 && y == 0)
                        d[x][y] = 1;
                    if (x == 0 && y != 0)
                        d[x][y] = d[x][y - 1];
                    if (x != 0 && y == 0)
                        d[x][y] = d[x - 1][y];
                    if (x != 0 && y != 0)
                        d[x][y] = d[x - 1][y] + d[x][y - 1];

                    d[x][y] %= 1000000007;
                }
            }
        }

        return d[m - 1][n - 1];
    }
}