package exhaustive_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre>
 * 문제 : BJ13701
 * 문제 링크 : https://www.acmicpc.net/problem/13701
 * 난이도 : 골드 4
 * 걸린 시간 : 30분
 * 알고리즘 : 비트마스킹
 *
 * 풀이
 * N은 500만개 즉 2^23 이하이다.  int는 2^5 만큼의 데이터를 담을 수 있다. 따라서 배열은 2^18 크기만큼 선언하고,
 * 각 배열의 인덱스에 알맞은 값을 넣으면 된다. 이후 중복체크를 위해 이 모든 것을 확인하면 된다.
 *
 * 라고 생각을 했는데 outOfBoundArray~ 가 뜨면서 실패했다. 아 문제를 다시 보자. N은 단순히 500만개가 아니라
 * N의 크기에 대한 제한 뿐이고, 실질적으로 가장 큰 수는 2^25  쯤이다. 따라서 2^25 / 2^5 해서 2^20 이 맞다.
 *
 * 나머지는, 입력받은 수에 대해 실제 index와, 해당 값 안의 비트 인덱스를 구한 다음, 중복 검사 후 출력하였다.
 * </pre>
 */
public class BJ13701 {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[(1 << 20)];

        while(st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            int index = val / 32;
            int bitIndex = val % 32;

            int indexOfVal = arr[index];
            if((indexOfVal & (1 << bitIndex)) == 0) {
                indexOfVal = indexOfVal | (1 << bitIndex);
                arr[index] = indexOfVal;
                sb.append(val).append(" ");
            }
        }

        System.out.println(sb);
    }
    
}
