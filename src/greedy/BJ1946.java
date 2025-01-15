package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
public class BJ1946 {
    public static int TC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for(int test = 0; test < TC; test++) {

            int N;
            N = Integer.parseInt(br.readLine());
            int result = N;
            int[][] arr = new int[N][2];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int tmpA = Integer.parseInt(st.nextToken());
                int tmpB = Integer.parseInt(st.nextToken());
                arr[i][0] = tmpA;
                arr[i][1] = tmpB;
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int b = arr[0][1];
            for(int i = 1; i < N; i++) {
                if(arr[i][1] > b) {
                    result--;
                } else {
                    b = arr[i][1];
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
