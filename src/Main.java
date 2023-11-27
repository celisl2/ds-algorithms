import sort.Sort;
import utils.Utils;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random rand = new Random();

    public static void main(String[] args) {

        System.out.println("Array before");
        int[] arr = getRandomArray(12, 99);
        System.out.println(Arrays.toString(arr));
        Sort.quickSort(arr, Utils.SortingType.V2);
        System.out.println("Array after");
        System.out.println(Arrays.toString(arr));
    }
    private static int[] getRandomArray(int length, int maxArrayValue){
        int[] nums = new int[length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(maxArrayValue);
        }
        return nums;
    }

}