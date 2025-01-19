package graph;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class BJ1865 {
    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static int N, M, W;
    static int[] dist;
    static ArrayList<ArrayList<Node>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            adj = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if (i < M) {
                    adj.get(start).add(new Node(end, weight));
                    adj.get(end).add(new Node(start, weight));
                } else {
                    adj.get(start).add(new Node(end, -weight));
                }
            }
            int INF = Integer.MAX_VALUE / 2;
            Arrays.fill(dist, INF);
            dist[1] = 0;
            boolean isUpdate = false;

            for(int i = 1; i < N; i++) {
                for(int j = 1; j <= N; j++) {
                    for(Node node : adj.get(j)) {
                        if(dist[node.end] > dist[j] + node.weight) {
                            dist[node.end] = dist[j] + node.weight;
                        }
                    }
                }
            }
            for(int i = 1; i <= N; i++) {
                for(Node node : adj.get(i)) {
                    if(dist[node.end] > dist[i] + node.weight) {
                        isUpdate = true;
                        break;
                    }
                }
            }
            int result;
            System.out.println((isUpdate) ? "YES" : "NO");


        }

    }
}
