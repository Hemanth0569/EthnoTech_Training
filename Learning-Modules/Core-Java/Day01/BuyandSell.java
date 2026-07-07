package Day01;

public class BuyandSell {
    public static void main(String[] args) {
        System.out.println(profit(new int[]{100,180,260,310,40,535,695}));
    }
    public static int profit(int arr[]){
        int buy=arr[0];
        int pro=0;
        int i;
        for(i=1;i<arr.length;i++){
            if(arr[i]<=buy){
                pro+=arr[i-1]-buy;
                if(i!=arr.length-1) buy=arr[i];
            }
            if(i==arr.length-1) pro+=arr[i]-buy;
        }
        return pro;
    }
}
