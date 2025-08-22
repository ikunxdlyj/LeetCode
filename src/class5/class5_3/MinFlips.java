package class5.class5_3;

public class MinFlips {
    public int minFlips(int a, int b, int c) {
        int cnt=0;
        for (int i = 0; i < 32; i++) {
            if((c>>i&1)==0){
                if((a>>i&1)==1){
                    cnt++;
                }
                if((b>>i&1)==1){
                    cnt++;
                }
            }else{
                if((a>>i&1)==0&&(b>>i&1)==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
