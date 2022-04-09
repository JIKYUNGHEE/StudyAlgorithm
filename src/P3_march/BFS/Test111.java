package P3_march.BFS;

public class Test111 {
    public static void main(String[] args) {
        PuddleSolution sol = new PuddleSolution();
        sol.solution(4, 3, new int[][]{{2,2}});
    }
}


class PuddleSolution {
    int route[][];
    public int solution(int m, int n, int[][] puddles) {
        route = new int[m+1][n+1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];

            route[x][y] = -1;
        }

        route[1][1] = 1;

        for (int i = 1; i < route.length; i++) {
            for(int j = 1; j < route[i].length; j++) {
                route[i][j] = route[i-1][j] + route[i][j-1];
            }
        }

        //sout
        for (int[] ints : route) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println();
        }

        return 0;
    }
}