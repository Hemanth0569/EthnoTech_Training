package Day01;

import java.util.Arrays;

public class Thief {
    public static void main(String[] args) {
        int[] arr = {5,4,3,8,5,1,0,2,8};

        int n = arr.length;
        int[] res = new int[2 * n];

        int odd = n;
        int even = n + (n / 2);

        for(int i = 0; i < n; i++) {
            res[i] = arr[i];

            if(i % 2 != 0) {
                res[odd++] = arr[i];
            } else {
                res[even++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(res));
    }
}