package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제 : 백준 14890
 * 문제 링크 : https://www.acmicpc.net/problem/14890
 * 난이도 : 골드 3
 * 걸린 시간 : 2시간
 * 알고리즘 : ?? / 그냥 구현 문제인듯
 *
 * 풀이
 * 높이가 변할 때마다, 각 L칸에 대해 적합한지 판정. 단, visited 를 사용하여, 이미 사용중인 칸,
 * 즉 이미 경사로가 존재하는 칸인 경우 false 반환 / 후에 카운팅
 *
 * </pre>
 */
public class BJ14890 {
    public static int[][] arr;
    public static int N;
    public static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L =  Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i = 0; i  < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(solution(arr[i])) cnt++;
            int[] tmp = new int[N];
            for(int j = 0; j < N; j++) {
                tmp[j] = arr[j][i];
            }
            if(solution(tmp)) cnt++;
        }

        System.out.println(cnt);



    }

    public static boolean solution(int[] path) {


        boolean[] visited = new boolean[N];
        for(int i = 1; i < N; i++) {
            if(path[i - 1] == path[i]) {
                continue;
            } else if(path[i - 1] == path[i] - 1) {
                boolean flag = true;
                for(int j = 1; j <= L; j++) {
                    if(i - j >= 0 && path[i - j] == path[i - 1] && !visited[i - j]) {
                        continue;
                    } else {
                        flag = false;
                    }
                }
                if(flag) {
                    for(int j = 1; j <= L; j++) {
                        visited[i - j] = true;
                    }
                    continue;
                } else {
                    return false;
                }
            } else if(path[i - 1] == path[i] + 1) {
                boolean flag = true;
                for(int j = 0; j < L; j++) {
                    if(i + j < N && path[i + j] == path[i] && !visited[i + j]) {
                        continue;
                    } else {
                        flag = false;
                    }
                }
                if(flag) {
                    for(int j = 0; j < L; j++) {
                        visited[i + j] = true;
                    }
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
