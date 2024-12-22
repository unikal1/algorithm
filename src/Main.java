/**
 * <br>package name   :
 * <br>file name      : ${NAME}
 * <br>date           : 12/19/24
 * <pre>
 * <span style="color: white;">[description]</span>
 *
 * </pre>
 * <pre>
 * <span style="color: white;">usage:</span>
 * {@code
 *
 * } </pre>
 */
public class Main {
    public static void Permutation(String[] arr, int start, int end) {
        if(start == end) {
            for(String i : arr) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        else {
            for(int i = start; i <= end; ++i) {
                swap(arr, start, i);
                Permutation(arr, start+1,end);
                swap(arr, start, i);
            }
        }
    }

    //인덱스 원소 바꾸기
    public static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    //예시) arr = ["A", "B", "C"] 순열 출력
    public static void main(String[] args) {
        String[] arr = new String[] {
                "A", "B", "C"
        };
        Permutation(arr, 0, arr.length-1);
    }
}