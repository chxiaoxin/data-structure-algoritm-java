import org.junit.Assert;
import org.junit.Test;

public class sortTest {

    private  void print(int[] nums) {
        for (int num: nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println("");
    }
    @Test
    public  void selectionSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        selection.selectionSort(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, nums);
        print(nums);
    }
    @Test
    public  void bubbleSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        selection.bubbleSort(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, nums);
        print(nums);
    }
    @Test
    public  void insertionSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        selection.insertionSort(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, nums);
        print(nums);
    }
    @Test
    public  void mergeSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        int[] sorted = selection.mergeSort(nums, 0, nums.length - 1);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, sorted);
        print(sorted);
    }
    @Test
    public  void quickSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        selection.quickSort(nums, 0, nums.length - 1);
        print(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, nums);
    }
    @Test
    public  void heapSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        selection.heapSort(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, nums);
        print(nums);
    }
    @Test
    public  void quickSelectTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        int num = selection.quickSelect(nums,6, 0, nums.length - 1);
        Assert.assertEquals(5, num);
        System.out.println(num);
    }
    @Test
    public  void countSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        int[] sorted = selection.countSort(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, sorted);
    }
    @Test
    public  void radixSortTest() {
        Sort selection = new Sort();
        int[] nums = new int[]{7,6,5,4,3,2,1,0};
        selection.LSDRadixSort(nums);
        print(nums);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7}, nums);

    }
}
