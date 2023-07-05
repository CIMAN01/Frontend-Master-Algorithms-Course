import java.lang.Math;

public class TwoCrystalBalls {

    // The Big O of this algorithm is O(sqrt(n))
    public static int twoCrystalBalls(int breaks[]) {
        // calculate a jump length with the sqrt of the array length
        int jumpLength = (int) Math.floor(Math.sqrt(breaks.length));
        int i = 0;

        // leaping through array with distance of sqrt in each leap
        for (; i < breaks.length; i += jumpLength) {
            if (breaks[i] == 1) {
                break;
            }
        }

        // jump back by one leap (sqrt length) to start walking forward linearly
        i -= jumpLength; // i = i - jumpLength;

        // walk linearly up to a sqrt length
        for (int j = i; j < i + jumpLength; j++) { // for (int j = 0; j < jumpLength && i < breaks.length; ++j, ++i)
            if (breaks[j] == 1) {
                return j;
            }
        }

        // if we reach here, it means the ball is not breaking within this height
        return -1;
    }


    public static void main(String[] args) {
        int[] breaks = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
        System.out.println(twoCrystalBalls(breaks)); // 7
    }

}
