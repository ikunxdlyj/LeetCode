package class1.class1_1.class1_1_1;

public class MaxVowels {
    public int maxVowels(String str, int k) {
        char[] s = str.toCharArray();
        int ans = 0, cur = 0;
        for (int r = 0; r < s.length; r++) {
            if (s[r] == 'a' || s[r] == 'e' ||s[r] == 'o' || s[r] == 'u') {
                cur++;
            }
            if(r<k-1){
                continue;
            }
            ans = Math.max(ans, cur);
            char out=s[r-k+1];
            if(out=='a'||out=='e'||out=='o'||out=='u'){
                cur--;
            }
        }
        return ans;
    }


}
