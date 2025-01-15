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
public class BJ4485 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static int N;
    public static int[][] map;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int index = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) return;

            map = new int[N][N];
            int[][] distance = new int[N][N];
            for(int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Queue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0,0,map[0][0]));
            while(!pq.isEmpty()) {
                Node now = pq.poll();
                int px = now.x;
                int py = now.y;
                int cost = now.cost;

                if(px == N - 1 && py == N - 1) {
                    System.out.println("Problem " + index++ + ": " + cost);
                    break;
                }
                for(int i = 0; i < 4; i++) {
                    int nextX = px + dx[i];
                    int nextY = py + dy[i];
                    if(nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) continue;

                    if(cost + map[nextX][nextY] < distance[nextX][nextY]) {
                        distance[nextX][nextY] = cost + map[nextX][nextY];
                        pq.add(new Node(nextX, nextY, distance[nextX][nextY]));
                    }
                }

            }


        }
    }
}
