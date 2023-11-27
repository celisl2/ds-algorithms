package sort;

import utils.Utils;

import java.util.Random;

public class Sort {

    public static void quickSort(int[] nums, Utils.SortingType type){
        if(type == Utils.SortingType.V1){
            System.out.println("using version one");
            quickSortV1(nums, 0, nums.length - 1);
        } else {
            System.out.println("using version two - preferred");
            quickSortV2(nums, 0, nums.length -1);
        }

    }

    private static void quickSortV2(int[] nums, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;
        int pivot = partitionV2(nums, startIndex, endIndex);
        System.out.println(pivot);
        quickSortV2(nums, startIndex, pivot - 1); //left sort
        quickSortV2(nums, pivot + 1, endIndex); //right sort
    }

    public static void quickSortV1(int[] nums, int lowIndex, int highIndex){
        if(lowIndex >= highIndex) return;

        //choose a pivot
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex; // get random index between low and high index
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, highIndex);

        int left = partitionV1(nums, pivot, highIndex, lowIndex);
        quickSortV1(nums, lowIndex,  left - 1);
        quickSortV1(nums, left + 1,  highIndex);
    }

    private static int partitionV1(int[] nums, int pivot, int highIndex, int lowIndex){
        int left = lowIndex;
        int right = highIndex - 1;

        while(left < right){
            while(nums[left] <= pivot && left < right) left++;
            while(nums[right] >= pivot && left < right) right--;
            swap(nums, left, right);
        }
        //by this point we know that left == pivot so we want to swap that
        if(nums[left] > nums[highIndex]) swap(nums, left, highIndex);
        else left = highIndex;

        return left;
    }

    public static int partitionV2(int[] nums, int left, int right){
        //generate random number within range
        int pivotIndex = new Random().nextInt(right - left) + left;

        //ensure our pivot is put in the last position of the array == swap right with pivotIndex
        swap(nums, pivotIndex, right);
        int pivot = nums[right];

        int indexOfSmallerNums = left - 1; //starts at -1 - keeps track of all numbers smaller than the pivot
        for (int indexOfLargerNumbers = left; indexOfLargerNumbers < right; indexOfLargerNumbers++) {
            //if the current item is less than the pivot
            if(nums[indexOfLargerNumbers] < pivot){
                indexOfSmallerNums++; //increment our counter of the smaller numbers
                if(indexOfLargerNumbers != indexOfSmallerNums) swap(nums, indexOfLargerNumbers, indexOfSmallerNums); //then swap w indexOfLargerNumbers which is keeping track of the larger ones
            }
        }
        swap(nums, indexOfSmallerNums + 1, right);
        return indexOfSmallerNums + 1;
    }

    private static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
