package class1.class1_1;

public class MaxScore {
    //    public int maxScore(int[] cardPoints, int k) {
//        int[][] dp = new int[cardPoints.length][cardPoints.length];
//        for (int i = 0; i < cardPoints.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return f(0, cardPoints.length - 1, k, cardPoints, k, dp);
//    }
//
//    public int f(int l, int r, int rest, int[] cardPoints, int k, int[][] dp) {
//        if (rest == 0) {
//            return 0;
//        }
//        if (dp[l][r] != -1) {
//            return dp[l][r];
//        }
//        int p1 = cardPoints[l] + f(l + 1, r, rest - 1, cardPoints, k, dp);
//        int p2 = cardPoints[r] + f(l, r - 1, rest - 1, cardPoints, k, dp);
//        dp[l][r] = Math.max(p1, p2);
//        return dp[l][r];
//    }


    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length - k;
        int minSum = Integer.MAX_VALUE;
        int sum = 0, sumAll = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sumAll += cardPoints[i];
            if (len == 0) {
                continue;
            }
            sum += cardPoints[i];
            if (i < len - 1) {
                continue;
            }
            minSum = Math.min(minSum, sum);
            // 当len=0且  i=n-1时，i-len+1=n+1，此时数组越界，从而报错；
            sum -= cardPoints[i - len + 1];
        }
        return len == 0 ? sumAll : sumAll - minSum;
    }
}
