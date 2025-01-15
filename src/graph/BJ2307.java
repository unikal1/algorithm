package graph;

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
public class BJ2307 {
    static class Node implements Comparable<Node>{
        int start;
        int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
        public Node(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }

    public static int N;
    public static int M;
    public static List<List<Node>> adj;

    public static int[] distance;
    public static int[] previous;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        previous = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Node(to, weight));
            adj.get(to).add(new Node(from, weight));
        }

        dijkstra(1);
        int minTime = distance[N];

        int lateTime = -1;
        for(int i = 2; i < N; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            dijkstra(1);
            lateTime = Math.max(distance[N], lateTime);
        }
        if(lateTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(lateTime - minTime);
        }


    }
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int cost = distance[now.start];
            for(Node node : adj.get(now.start)) {
                if(visited[node.start]) continue;
                if(node.cost + cost < distance[node.start]) {
                    distance[node.start] = node.cost + cost;

                    pq.add(new Node(node.start, distance[node.start]));
                }
            }
        }
    }

}
