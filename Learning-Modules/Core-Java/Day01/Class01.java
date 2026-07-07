package Day01;
import java.util.*;
public class Class01 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        for(int i=0;i<arr.length-1;i++) {
            arr[i + 1] = arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}
