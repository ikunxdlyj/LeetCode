package class1.class1_1;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] nums={1,5,4,2,9,9,9};
        int k=3;
        System.out.println(maximumSubarraySum(nums, k));
    }
    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans=Long.MIN_VALUE;
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(i<k-1){
                continue;
            }
            if(map.size()==k){
                ans = Math.max(ans,sum);
            }
            sum -= nums[i - k+1];
            int cnt=map.get(nums[i-k+1]);
            if(cnt>1){
                map.put(nums[i-k+1],cnt-1);
            }else{
                map.remove(nums[i-k+1]);
            }
        }
        return ans==Long.MIN_VALUE?0:ans;
    }
}
