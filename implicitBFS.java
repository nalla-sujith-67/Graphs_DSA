import java.util.*;

class Pair {
    int ele;
    int level;

    Pair(int ele, int level) {
        this.ele = ele;
        this.level = level;
    }
}

class Main {
    int xarr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    int yarr[] = {0, 1, 1, 1, 0, -1, -1, -1};
    int ans[][];

    public int[][] solve(int r, int c, int si, int sj) {
        ans = new int[r][c];

       
        for (int i = 0; i < r; i++) {
            Arrays.fill(ans[i], 0);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(si, sj));
        ans[si][sj] = 1; 

        while (!queue.isEmpty()) {
            Pair pos = queue.remove();
            int element = pos.ele;
            int lvl = pos.level;

            for (int i = 0; i < 8; i++) {
                int a = element + xarr[i];
                int b = lvl + yarr[i];

                // Check if the new position is valid and not visited
                if (a >= 0 && a < r && b >= 0 && b < c && ans[a][b] == 0) {
                    queue.add(new Pair(a, b));
                    ans[a][b] = 1 + ans[element][lvl];
                }
            }
        }

        return ans;
    }
}
