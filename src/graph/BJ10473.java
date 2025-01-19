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
public class BJ10473 {
    static class Node implements Comparable<Node> {
        double x;
        double y;
        double cost;
        int num;
        public Node(double x, double y, double cost, int num) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.num = num;
        }
        @Override
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    public static double sx, sy;
    public static double ex,ey;
    public static double[] distance;
    public static boolean[] visited;
    public static Node[] nodes;

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sx = Double.parseDouble(st.nextToken());
        sy = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Double.parseDouble(st.nextToken());
        ey = Double.parseDouble(st.nextToken());
        N = Integer.parseInt(br.readLine());

        distance = new double[N + 2];
        visited = new boolean[N + 2];
        nodes = new Node[N + 2];
        Arrays.fill(visited, false);
        Arrays.fill(distance, Double.MAX_VALUE);
        nodes[0] = new Node(sx, sy, 0, 0);
        nodes[N + 1] = new Node(ex, ey, 0, N+1);
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double px = Double.parseDouble(st.nextToken());
            double py = Double.parseDouble(st.nextToken());
            nodes[i] = new Node(px, py, 0, i);
        }
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(nodes[0]);
        distance[0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.num]) continue;
            visited[now.num] = true;

            for(int i = 0; i <= N + 1; i++) {
                if(i == now.num) continue;

                double cost = distance[now.num] + getTime(now.num, i);
                if(cost < distance[i]) {
                    distance[i] = cost;
                    pq.add(new Node(nodes[i].x, nodes[i].y, distance[i], i));
                }
            }

        }

        System.out.printf("%.6f", distance[N + 1]);


    }

    public static double getDis(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double getTime(int now, int next) {
        double dis = getDis(nodes[now].x, nodes[now].y, nodes[next].x, nodes[next].y);
        double runTime = dis / 5.0;

        if (now >= 1 && now <= N) {
            double cannonTime = 2.0 + Math.max(0.0, dis - 50.0) / 5.0;
            return Math.min(runTime, cannonTime);
        } else {
            return runTime;
        }
    }



}
