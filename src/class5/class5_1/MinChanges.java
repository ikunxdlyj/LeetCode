package class5.class5_1;

public class MinChanges {
    public int minChanges(int n, int k) {
        int xor = n ^ k;
        int cnt = 0;
        while (xor != 0) {
            int rightOne = xor & (-xor);
            if((rightOne&n)==0){
                return -1;
            }
            cnt++;
            xor^=rightOne;
        }
        return cnt;
    }
}
