package DP;

import java.util.Arrays;

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
public class PG43105 {

    public static void main(String[] args) {
        int[][] input = {{7}, {3,8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int val = solution(input);
        System.out.println(val  );

    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[502][502];
        for(int i = 0; i < 502; i++) {
            Arrays.fill(dp[i], 0);
        }
        int layer = 0;
        int fullLayer = triangle.length;
        while(fullLayer > layer) {
            int[] val = triangle[layer++];
            int len = val.length;
            for(int i = 0; i < len; i++) {
                dp[layer + 1][i + 1] = Math.max(dp[layer][i], dp[layer][i + 1]) + val[i];

            }
        }
        int max = -1;
        for(int i = 0; i < triangle[fullLayer - 1].length; i++) {
            if(max < dp[fullLayer + 1][i]) {
                max = dp[fullLayer + 1][i];
            }
        }
        return max;
    }

}
