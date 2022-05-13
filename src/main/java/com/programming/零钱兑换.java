package com.programming;

public class 零钱兑换 {

    public static int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0 || amount < 0){
            return -1;
        }
        //dp[i] = dp[i-face]+1
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if(coin > i || dp[i-coin] < 0){
                    continue;
                }
                min = Math.min(dp[i-coin],min);
            }
            if(min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min +1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int min = coinChange(new int[]{1,5,20,25},  11);
        System.out.println(min);
    }
}
