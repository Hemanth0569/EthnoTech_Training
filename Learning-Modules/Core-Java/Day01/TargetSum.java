package Day01;

public class TargetSum {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,8,12,16,18};
        int target=20;
        System.out.println(targetsum(arr,target));
    }
    public static boolean targetsum(int[] arr,int target){
        //Two Pointers
        int l=0,r=arr.length-1;
        int sum=0;
        while(l<r){
            sum=arr[l]+arr[r];
            if(sum==target) return true;
            else if(sum<target) l++;
            else r--;
        }
        return false;
    }
}
