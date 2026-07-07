package DynamicProgramming;

import java.util.HashMap;

public class DPFibS {
    public static void main(String[] args) {
        System.out.println(helper(4));
    }

    public static int helper(int n)
    {
        return dpfs(n, new HashMap<>());
    }

    public static int dpfs(int n, HashMap<Integer, Integer> memo)
    {
        if(n<2)
        {
            return n;
        }

        if(memo.containsKey(n))
        {
            return memo.get(n);
        }

        int result = dpfs(n-1, memo) + dpfs(n-2, memo);
        memo.put(n, result);
        return result;
    }
}
