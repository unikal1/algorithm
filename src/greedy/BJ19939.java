package greedy;

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
public class BJ19939 {

    public static int N;
    public static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i = 1; i <= K; i++) {
            sum += i;
        }
        if(sum > N) {
            System.out.println(-1);
        } else if(sum == N) {
            System.out.println(K - 1);
        } else {
            int per = (N - sum) % K;
            if(per == 0) {
                System.out.println(K - 1);
            } else {
                System.out.println(K);
            }
        }
    }
}
