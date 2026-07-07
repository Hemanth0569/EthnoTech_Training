package Recursion;

public class Fibna {
    public static void main(String[] args){
        System.out.println(fib(4));
        System.out.println(BS(new int[]{0,3,5,8,11,22,88,155},88));
        int[] arr={0,3,5,8,11,22,88,155};
        System.out.println(BSR(arr,88,0,arr.length-1));
    }

    public static int fib(int n){
        if(n<2) return n;
        return fib(n-1)+fib(n-2);
    }

    public static int BS(int[] arr,int tar){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==tar) return mid;
            else if(tar>arr[mid]) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    public static int BSR(int[] arr,int tar,int l,int h){
        if(l>h) return -1;
        int mid=l+(h-l)/2;
        if(arr[mid]==tar) return mid;
        else if(tar>arr[mid]) return BSR(arr,tar,mid+1,h);
        else return BSR(arr,tar,l,mid-1);
    }
}
