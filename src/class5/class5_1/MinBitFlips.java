package class5.class5_1;

public class MinBitFlips {
    public int minBitFlips(int start, int goal) {
        int xor=start^goal;
        int cnt=0;
        int rightOne;
        while ((xor != 0)) {
            cnt++;
            rightOne=xor&(-xor);
            xor^=rightOne;
        }
        return cnt;
    }
}
