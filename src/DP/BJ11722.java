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
 * 걸린 시간 : 10분
 * 알고리즘 :
 *
 * 풀이
 *
 * </pre>
 */
public class BJ11722 {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        for(int i = 1 ; i < N; i++) {
            int max = -1;
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            if(max == -1) {
                dp[i] = 1;
            } else {
                dp[i] = max + 1;
            }

        }

        int max = -1;
        for(int i = 0; i < N; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
