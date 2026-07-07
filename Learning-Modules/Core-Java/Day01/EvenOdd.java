package Day01;

import java.util.Arrays;

public class EvenOdd {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(evenodd(arr)));
    }
    public static int[] evenodd(int[] arr){
        //Two Pointers
        int l=0,r=arr.length-1;
        while(l<r){
            if(arr[l]%2==0 && arr[r]%2!=0){
                l++;
                r--;
            }
            else if(arr[l]%2==0) l++;
            else if(arr[r]%2!=0) r--;
            else{
                int t=arr[r];
                arr[r]=arr[l];
                arr[l]=t;
                l++;
                r--;
            }
        }
        return arr;
    }
}
