package class5.class5_1;

public class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            res[i]=countOne(i);
        }
        return res;
    }
    public int countOne(int num){
        int cnt=0;
        while(num!=0){
            int rightOne=num&(-num);
            num^=rightOne;
            cnt++;
        }
        return cnt;
    }
}
