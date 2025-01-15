package graph;

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
public class BJ20040 {
    public static int N;
    public static int M;
    public static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a, b)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
        return;
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
            return false;
        } else {
            return true;
        }

    }
    public static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }


}
