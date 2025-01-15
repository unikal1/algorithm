package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제 :
 * 문제 링크 :
 * 난이도 :
 * 걸린 시간 :
 * 알고리즘 :
 *
 * 풀이
 *
 * </pre>
 */
public class BJ2293 {
    public static int N;
    public static int K;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int first = arr[0];
        for (int i = 1; i <= K; i++) {
            if (i % first != 0) {
                dp[1][i] = 0;
            } else {
                dp[1][i] = 1;
            }
        }

        for (int i = 2; i <= N; i++) {

            for (int j = 1; j <= K; j++) {
                int val;
                int idx = j - arr[i - 1];

                if (idx == 0) {
                    val = 1;
                } else if (idx < 0) {
                    val = 0;
                } else {
                    val = dp[i][idx];
                }
                dp[i][j] = dp[i - 1][j] + val;
            }
        }

        System.out.println(dp[N][K]);


    }
}
