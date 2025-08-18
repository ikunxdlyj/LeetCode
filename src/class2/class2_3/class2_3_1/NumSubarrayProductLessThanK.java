package class2.class2_3.class2_3_1;

public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if(k<=1){
          return 0;
      }
      int ans=0;
      int mul=1;
      for(int l=0,r=0;r<nums.length;r++){
          mul*=nums[r];
          while(mul>=k){
              mul/=nums[l++];
          }
          ans+=r-l+1;
      }
      return ans;
    }
}
