package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
public class BJ1700 {
    public static int N;
    public static int M;
    public static int[] arr;
    public static Set<Integer> plug;

    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        plug = new HashSet<>();

        arr =  new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            if(plug.contains(arr[i])) {
                continue;
            } else if(plug.size() < N) {
                plug.add(arr[i]);
            } else {

                int index = -1;
                int value = -1;
                for(Integer it : plug) {
                    int used = 101;
                    for(int j = i + 1; j < M; j++) {
                        if(arr[j] == it) {
                            used = j;
                            break;
                        }
                    }
                    if(used > index) {
                        index = used;
                        value = it;
                    }
                }
                plug.remove(value);
                plug.add(arr[i]);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
