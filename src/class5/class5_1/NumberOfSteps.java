package class5.class5_1;

public class NumberOfSteps {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            }else{
                num--;
            }
            cnt++;
        }
        return cnt;
    }
}
