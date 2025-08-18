package class1.class1_2;

public class MaxFreeTime {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int ans = eventTime;
        for (int i = 0; i < startTime.length; i++) {
            ans-=endTime[i]-startTime[i];
        }
        return ans;
    }
}
