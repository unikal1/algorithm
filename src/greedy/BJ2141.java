package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class BJ2141 {
    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        long sum = 0;
        for(int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr[i][1] = val;
            sum += val;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
                return o1[0] - o2[0];
        });

        long topSum = 0;
        int index = 0;
        while (topSum < (sum+1) / 2) {
            topSum += arr[index][1];
            index++;
        }

        System.out.println(arr[index - 1][0]);
    }
}
