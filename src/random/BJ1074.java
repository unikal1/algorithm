package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제 : BJ1074
 * 문제 링크 : https://www.acmicpc.net/problem/1074
 * 난이도 : 골드 5
 * 걸린 시간 : 25분
 * 알고리즘 : 재귀, 분할정복
 *
 * 풀이
 * 사이즈가 2^n 인 정사각형에 대해, 몇 사분면인지 계산하고, 해당 좌표가 포함된 사분면에 대해
 * 2^n-1 에 대한 정사각형으로 나누어 구하게끔 하였다.
 * 재귀적 호출을 통해 종래에 n = 0 가 될 때 결과물을 출력하도록 하였으며,
 * (지금 보니 n = 1일 때 start + flag하면 더 시간 절약했을듯)
 * 매 사분면의 처음 블럭의 시작은 2^(2n-2) * flag(사분면 - 1)임을 이용하여 풀었다.
 *
 * 처음 제출 시, 한번 틀렸는데 사분면 계싼 로직을 두번 하여 꼬인 것이다.
 * </pre>
 */
public class BJ1074 {

    public static int N;
    public static int r;
    public static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());



        solution(0, N,0,0);
    }

    public static void solution(int start, int size, int startX, int startY) {
        if(size == 0) {
            System.out.println(start);
            return;
        }
        boolean flagX, flagY;

        flagX = c < startX + Math.pow(2, size - 1);
        flagY = r < startY + Math.pow(2, size - 1);

        int flag = (flagX ? 0 : 1) + (flagY ? 0 : 2);


        int startPoint = (int) Math.pow(2, 2 * size - 2) * flag + start;

        int half = (int) Math.pow(2, size - 1);

        if ((flag & 1) == 1) {
            startX += half;
        }
        if ((flag & 2) == 2) {
            startY += half;
        }


        solution(startPoint, size - 1, startX, startY);

    }
}
