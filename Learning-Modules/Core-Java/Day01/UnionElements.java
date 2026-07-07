package Day01;

import java.util.ArrayList;

public class UnionElements {
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5,6};
        int arr2[]={2,4,6,8,10};
        int arr3[]={2,3,6,9,12};
        System.out.println(intersection(arr1,arr2,arr3));
    }
    public static ArrayList<Integer> intersection(int[] arr1,int[] arr2,int[] arr3){
        ArrayList<Integer> ans=new ArrayList<>();
        /*for(int i=0;i<arr1.length;i++){
            boolean flag=false;
            int num=arr1[i];
            for(int j=0;j<arr2.length;j++){
                if(num==arr2[j]){
                    flag=true;
                    break;
                }
            }
            if(flag){
                for(int k=0;k<arr3.length;k++){
                    if(num==arr3[k]){
                        ans.add(num);
                        break;
                    }
                }
            }
        }
        return ans;*/
        //Three Pointers
        int x=0,y=0,z=0;
        while(x<arr1.length && y<arr2.length && z<arr3.length){
            if(arr1[x]==arr2[y] && arr2[y]==arr3[z]){
                ans.add(arr1[x]);
                x++;
                y++;
                z++;
            }
            else if(arr1[x]<arr2[y]) x++;
            else if(arr2[y]<arr3[z]) y++;
            else z++;
        }
        return ans;
    }
}