package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
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
public class BJ15486 {
    public static int N;
    public static int[][] arr;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][2];
        dp = new int[N + 2];
        Arrays.fill(dp, 0);
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for(int i = 1; i <= N; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
            if((i + arr[i][0]) <= N + 1) {
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], max + arr[i][1]);
            }
        }
        max = Math.max(max, dp[N + 1]);

        System.out.println(max);
    }
}
