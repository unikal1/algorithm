package random;

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
public class BJ1987 {
    public static int R;
    public static int C;
    public static int[][] map;
    public static boolean[][] visited;

    public static int[][] loop = {{-1,0}, {1,0},{0,-1}, {0, 1}};

    public static int max;

    public static boolean[] dup;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        max = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        dup = new boolean[26];
        for(int i = 0; i < R; i++) {
            String value = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] =  value.charAt(j)- 'A';
                visited[i][j] = false;
            }
        }

        dfs(0,0, 1);
        System.out.println(max);

    }

    public static void dfs(int x, int y, int depth) {
        if(x >= R || y >= C || dup[map[x][y]]) {
            if(max < depth - 1) {
                max = depth - 1;
            }
            System.out.println("in " + depth + " max is " + max);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(x + loop[i][0] >= 0 && y + loop[i][1] >= 0 && !visited[x + loop[i][0]][y + loop[i][1]]) {
                visited[x + loop[i][0]][y + loop[i][1]] = true;
                dfs(x + loop[i][0], y + loop[i][1], depth);
                visited[x + loop[i][0]][y + loop[i][1]] = false;
            }
        }
    }
}
