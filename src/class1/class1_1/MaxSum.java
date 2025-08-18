package class1.class1_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSum {

    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        long ans=0;
        long sum=0;
        for(int i=0;i<nums.size();i++){
            int in=nums.get(i);
            sum+=in;
            map.put(in,map.getOrDefault(in,0)+1);
            if(i<k-1){
                continue;
            }
            if(map.size()>=m){
                ans=Math.max(ans,sum);
            }
            int out=nums.get(i-k+1);
            int cnt=map.get(out);
            sum-=out;
            if(cnt>1){
                map.put(out,cnt-1);
            }else {
                map.remove(out);
            }
        }
        return ans;
    }

}
