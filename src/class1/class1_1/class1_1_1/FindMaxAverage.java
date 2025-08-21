package class1.class1_1.class1_1_1;

public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double ans=Integer.MIN_VALUE;
        double cur=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur+=nums[i];
            if(i<k-1){
                continue;
            }
            ans=Math.max(ans,cur);
            cur-=nums[i-k+1];
        }
        return ans/k;
    }
}
