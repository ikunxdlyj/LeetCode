package class2.class2_3.class2_3_1;

public class CountKConstraintSubstrings {
    // TODO
    public int countKConstraintSubstrings(String str, int k) {
        char[] s = str.toCharArray();
        int[] sum = new int[s.length];
        sum[0] = s[0] - '0';
        for (int i = 1; i < s.length ; i++) {
            sum[i] = sum[i - 1] + s[i] - '0';
        }
        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            for(int j=i;j<s.length;j++){
                int ones=sum[j]-sum[i]+s[i]-'0';
                int zeros=j-i+1-ones;
                if(ones<=k||zeros<=k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
