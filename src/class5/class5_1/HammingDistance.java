package class5.class5_1;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int cnt=0;
        int rightOne;
        int xor=x^y;
        while(xor!=0){
            cnt++;
            rightOne=xor&(-xor);
            xor^=rightOne;
        }
        return cnt;
    }
}
