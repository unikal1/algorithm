package notSolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * 문제 : BJ1947
 * 문제 링크 :
 * 난이도 : 골드 3
 * 걸린 시간 : 이틀
 * 알고리즘 : dynamic programming
 *
 * 풀이
 * 대충 보니 완전순열 문제이다. 교란 순열로도 불린다.
 * n명의 참가자가 있을 때, 기존 n-1 명에 비해 새로운 a라는 사람이 추가되었다고 해보자.
 * 1. n - 2명일 때, a와, 무작위 사람 b인 사람이 서로 a-> b -> a로 교환할 때이다.
 *      이때 b를 고르는 경우는 n-1이므로 (n-1)*dp[n-1] 이다.
 * 2. n - 1명일 때, a가 기존의 n-1이 생성하는 여러 선물 교환 관계의 간선에 끼어든다고 해보자.
 *      각 간선은 n-1개 존재하므로, a는 이 중 하나에 참여하는 것이다.
 *      즉, 기존에 x->y->z->x 라는 교환 관계를 가지고 있는 기존 경우가 있을 때, a는 가령
 *      x->a->y->z->x에 끼어들 수 있고 이는 x->y 사이의 간선에 끼어든 것이다. 따라서
 *      (n-1) * dp[n-1]이다.
 * 3. n - 3은 영향이 없나 생각해보자.
 *      (점화식에dp[n-3]이 끼어들 건덕지가 있을까? 혹은 경우가 겹치지 않을까)
 *      n-3에 3명이 추가된 경우인데, 3명은 가령 a->b->c->a의 사이클을 돌거나
 *      두 사람이 a->b->a가 되고 c는 기존의 n-4인 경우에 참여하는 경우이다.
 *      그러나 이는 n-1과 n-2인 경우와 겹친다.
 *
 * 따라서 점화식은 (n-1)(dp[n-2] + dp[n-1]) 이다.
 * </pre>
 */
public class BJ1947 {

    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long n = solution(N);

        System.out.println(n);
    }

    public static long solution(int n) {

        long[] dp = new long[(n >= 4) ? (n + 1) : (4)];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        if(n < 4) {
           return dp[n];
        }
        int index = 4;
        while(index <= n) {
            dp[index] = ((index - 1) * (dp[index - 2] + dp[index - 1])) % 1000000000;
            index++;
        }
        return dp[n];
    }
}
