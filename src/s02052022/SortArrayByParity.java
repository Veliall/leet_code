package s02052022;

import java.util.Arrays;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] ints = {0, 1, 34, 33, 445, 6};
        System.out.println(Arrays.toString(sortArrayByParity(ints)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int[] firstPart = Arrays.stream(nums).filter(o -> o % 2 == 0).toArray();
        int[] secondPart = Arrays.stream(nums).filter(o -> o % 2 != 0).toArray();

        int[] result = Arrays.copyOf(firstPart, firstPart.length + secondPart.length);
        System.arraycopy(secondPart, 0, result, firstPart.length, secondPart.length);
        return result;
    }
}