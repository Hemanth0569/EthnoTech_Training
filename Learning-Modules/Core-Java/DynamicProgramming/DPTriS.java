package DynamicProgramming;

import java.util.HashMap;

public class DPTriS {

    public static void main(String[] args) {
        System.out.println(helper(6));
    }

    public static int helper(int n)
    {
        return dpts(n,new HashMap<>());
    }

    public static int dpts(int n, HashMap<Integer, Integer> memo)
    {
        if(n==0 || n==1) return 0;
        if(n==2) return 1;

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int res = dpts(n-1, memo) + dpts(n-2, memo) + dpts(n-3, memo);
        memo.put(n, res);
        return res;
    }
}
