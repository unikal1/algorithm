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
public class BJ16953 {
    public static int a;
    public static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (a < b) {
            cnt++;
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b = (b - 1) / 10;
            } else {
                break;
            }
        }
        if (a != b) {
            System.out.println(-1);
        } else {
            System.out.println(cnt + 1);
        }
    }

}
