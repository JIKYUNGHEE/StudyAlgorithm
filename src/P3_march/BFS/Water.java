package P3_march.BFS;

import java.util.HashSet;

public class Water {

}


class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] memo = new long[m][n];
        HashSet<String> puddleSet = new HashSet<>();
        for(int[] puddle : puddles) {
            puddleSet.add(puddle[0] + "," + puddle[1]);
        }
        return (int)(dfs(1, 1, m, n, puddleSet, memo) % 1000000007L);
    }
    public long dfs(int x, int y, int m, int n, HashSet<String> puddles, long[][] memo) {
        if(x > m || y > n || puddles.contains(x + "," + y)) return 0;
        if(x == m && y == n) return 1;
//        if(memo[x - 1][y - 1] > 0) return memo[x - 1][y - 1] - 1;
        memo[x - 1][y - 1] = dfs(x + 1, y, m, n, puddles, memo) + dfs(x, y + 1, m, n, puddles, memo) + 1;
        return memo[x - 1][y - 1] - 1;
    }
}