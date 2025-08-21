package class1.class1_1.class1_1_1;

public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sumMean=k*threshold;
        int cnt=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(i<k-1){
                continue;
            }
            if(sum>=sumMean){
                cnt++;
            }
            sum-=arr[i-k+1];
        }
        return cnt;
    }
}
