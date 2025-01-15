package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
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
public class BJ1781 {
    public static int N;
    public static PriorityQueue<int[]> pq;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });

        int max = -1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            if(deadLine > max) {
                 max = deadLine;
            }
            int[] input = {deadLine, reward};
            pq.add(input);
        }

        result = new int[max + 1];
        Arrays.fill(result, 0);
        int index = 1;
        int point = max;


        while(!pq.isEmpty() && point > 0) {
            //System.out.println("In " + index++ + ", peek of pq is " + pq.peek()[0] + " " + pq.peek()[1] + "and point is " + point);

            if(pq.peek()[0] >= point) {
                if(result[point] < pq.peek()[1]) {
                    result[point] = pq.remove()[1];
                } else {
                    pq.remove();
                }
                //System.out.println("add " + result[point] + " at " + point);
            } else {
                point--;
            }

        }
        long sum = 0;
        for(int i = 1; i <= max; i++) {
            sum += result[i];
        }

        System.out.println(sum);





    }
}
