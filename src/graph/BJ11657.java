package graph;

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
public class BJ11657 {
    public static int N;
    public static int M;
    public static long[] dist;
    public static Node[] nodes;

    static class Node {
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        nodes = new Node[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dist[1] = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                Node node = nodes[j];
                if(dist[node.x] != Integer.MAX_VALUE && dist[node.y] > dist[node.x] + node.cost) {
                    dist[node.y] = dist[node.x] + node.cost;
                }
            }
        }
        for(int i = 0; i < M; i++) {
            Node node = nodes[i];
            if(dist[node.x] != Integer.MAX_VALUE && dist[node.y] > dist[node.x] + node.cost) {
                System.out.println("-1");
                return;
            }
        }

        for(int i = 2; i <= N; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(dist[i]);
            }
        }

    }
}
