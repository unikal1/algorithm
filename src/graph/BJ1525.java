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
public class BJ1525 {
    public static class Mat {
        int[] arr;
        public Mat(int[] arr) {
            this.arr = arr;
        }
        public Mat(Mat other) {
            this(other.arr.clone());
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Mat)) {
                return false;
            }
            return Arrays.equals(this.arr, ((Mat)o).arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }
    public static Set<Mat> findedSet;
    public static Queue<Mat> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        findedSet = new HashSet<>();
        queue = new LinkedList<>();
        int[] initArr = new int[9];
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                initArr[3 * i + j] = Integer.parseInt(st.nextToken());
            }
        }
        if (!isSolvable(initArr)) {
            System.out.println(-1);
            return;
        }
        Mat initMat = new Mat(initArr);
        queue.add(initMat);
        findedSet.add(initMat);
        System.out.println(bfs(0));

    }

    static boolean isSolvable(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (arr[i] != 0) {
                list.add(arr[i]);
            }
        }
        int inversions = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    inversions++;
                }
            }
        }
        return (inversions % 2 == 0);
    }

    public static int bfs(int depth) {
        int steps = depth;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Mat mat = queue.poll();
                boolean isComplete = true;
                for(int i = 0; i < 8; i++) {
                    if(mat.arr[i] != i + 1) {
                        isComplete = false;
                    }

                }
                if(mat.arr[8] != 0) {
                    isComplete = false;
                }
                if(isComplete) {
                    return steps;
                }
                int blankIdx = 0;
                for(int i = 0; i < 9; i++) {
                    if(mat.arr[i] == 0) {
                        blankIdx = i;
                    }
                }
                int[] near = nearIdx(blankIdx);
                for(int i = 0; i < near.length; i++) {
                    Mat newMat = swap(mat, blankIdx, near[i]);
                    if(!findedSet.contains(newMat)) {
                        queue.add(newMat);
                        findedSet.add(newMat);
                    }
                }
            }
            steps++;
        }
        return -1;
    }


//    public static int[] nearIdx(int idx) {
//        return switch (idx) {
//            case 0 -> new int[]{1,3};
//            case 1 -> new int[]{0,2,4};
//            case 2 -> new int[]{1,5};
//            case 3 -> new int[]{0,4,6};
//            case 4 -> new int[]{1,3,5,7};
//            case 5 -> new int[]{2,4,8};
//            case 6 -> new int[]{4,7};
//            case 7 -> new int[]{4,6,8};
//            case 8 -> new int[]{5,7};
//            default -> new int[]{0};
//        };
//    }
public static int[] nearIdx(int idx) {
    switch (idx) {
        case 0:
            return new int[]{1, 3};
        case 1:
            return new int[]{0, 2, 4};
        case 2:
            return new int[]{1, 5};
        case 3:
            return new int[]{0, 4, 6};
        case 4:
            return new int[]{1, 3, 5, 7};
        case 5:
            return new int[]{2, 4, 8};
        case 6:
            return new int[]{3, 7};
        case 7:
            return new int[]{4, 6, 8};
        case 8:
            return new int[]{5, 7};
        default:
            return new int[]{0};
    }
}
    public static Mat swap(Mat mat, int a, int b) {
        Mat newMat = new Mat(mat);
        int tmp = newMat.arr[a];
        newMat.arr[a] = newMat.arr[b];
        newMat.arr[b] = tmp;
        return newMat;
    }
}
