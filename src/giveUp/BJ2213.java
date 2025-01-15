package giveUp;

import java.io.*;
import java.util.*;

public class BJ2213 {
    static int N;
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[][] dp;
    static int[] W;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        visited[1] = true;
        dfs(1);

        Arrays.fill(visited, false);
        result = new ArrayList<>();

        int maxVal;
        if (dp[1][0] > dp[1][1]) {
            backtrack(1, false);
            maxVal = dp[1][0];
        } else {
            backtrack(1, true);
            maxVal = dp[1][1];
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(maxVal).append("\n");
        for (Integer node : result) {
            sb.append(node).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int u) {
        dp[u][0] = W[u];
        dp[u][1] = 0;

        for (int v : tree.get(u)) {
            if (!visited[v]) {
                visited[v] = true;
                dfs(v);
                dp[u][0] += dp[v][1];
                dp[u][1] += Math.max(dp[v][0], dp[v][1]);
            }
        }
    }

    static void backtrack(int u, boolean parentSelected) {
        visited[u] = true;

        boolean isUSelected;
        if (parentSelected) {
            isUSelected = false;
        } else {
            if (dp[u][0] > dp[u][1]) {
                isUSelected = true;
                result.add(u);
            } else {
                isUSelected = false;
            }
        }

        // 자식들에 대해서 재귀 호출
        for (int v : tree.get(u)) {
            if (!visited[v]) {
                backtrack(v, isUSelected);
            }
        }
    }
}