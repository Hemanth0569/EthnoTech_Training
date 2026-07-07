package Day01;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr={2,-5,1,7,-3,4,-6};
        //Kadane's
        int sum=arr[0];
        int maxi=arr[0];
        for(int i=1;i<arr.length;i++){
            sum=Math.max(sum+arr[i],arr[i]);
            maxi=Math.max(maxi,sum);
        }
        System.out.println(maxi);
    }
}
