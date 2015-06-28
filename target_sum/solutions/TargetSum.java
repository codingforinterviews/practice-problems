import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TargetSum {

    public boolean hasPair(int[] values, int expectedSum) {
        Arrays.sort(values);
        int left = 0;
        int right = values.length - 1;

        for (; left < right; ) {
            int actualSum = values[left] + values[right];
            if (actualSum > expectedSum) {
                right--;
            } else if (actualSum < expectedSum) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean hasPairUsingSet(int[] values, int expectedSum) {

        Set<Integer> seenValues = new HashSet<>();
        for (int value : values) {
            int diff = expectedSum - value;
            if (!seenValues.contains(diff)) {
                seenValues.add(value);
            } else {
                //Found it is diffvalue & currvalue that wil make up sum
                return true;
            }
        }
        return false;
    }
}
