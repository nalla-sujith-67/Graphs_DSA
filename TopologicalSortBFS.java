import java.util.*;

class Main {
    public ArrayList<Integer> solve(int n, int m, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

      for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        // Declaring the indegree array to store the indegrees of the nodes
        int indeg[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
            indeg[v]++;
        }
      //taken priority queue to print the order of the elements in the lexicographical order.
      Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int ele = queue.remove();
            ans.add(ele);

            for (int neighbor : map.get(ele)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return ans;
    }
}
