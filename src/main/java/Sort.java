public class Sort {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] =temp;
        return;
    }

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length  - 1; i++) {
            int minIndex = i;
            int minValue = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < minValue) {
                    minIndex = j;
                    minValue = nums[j];
                }
            }
            swap(nums, minIndex, i);
        }
    }

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public void insertionSort(int[] nums) {
        for (int i = 0; i  < nums.length; i++) {
           for (int j = i; j > 0; j--) {
               if (nums[j] < nums[j - 1]) {
                   swap(nums, j - 1, j);
               }
           }
        }
    }

    public int[] merge(int[] n1, int[] n2) {
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] merged = new int[n1.length + n2.length];
        while (p1 < n1.length && p2 < n2.length) {
            if (n1[p1] < n2[p2]) {
                merged[index] = n1[p1];
                p1++;
                index++;
            } else {
                merged[index] = n2[p2];
                p2++;
                index++;
            }
        }
        while (p1 < n1.length) {
            merged[index] = n1[p1];
            index++;
            p1++;
        }
        while (p2 < n2.length) {
            merged[index] = n2[p2];
            index++;
            p2++;
        }
        return merged;
    }

    public int[] mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            int[] a = mergeSort(nums, start, mid);
            int[] b = mergeSort(nums, mid + 1, end);
            return merge(a, b);
        } else {
            return new int[]{nums[start]};
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;
        while(left < right) {
            if (nums[left] >= nums[pivot] && nums[right] < nums[pivot]) {
                swap(nums, left++, right--);
            }
            if (nums[left] < nums[pivot]) {
                left++;
            }
            if (nums[right] >= nums[pivot]) {
                right--;
            }
        }
        if (nums[right] > nums[pivot]) {
            right--;
        }
        swap(nums, right, pivot);
        return right;
    }

    public int lpartition(int[] nums, int start, int end) {
        int left = start;
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, end);
        return index;
    }

    public int hpartition(int[] nums, int start,int end) {
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (true) {
            while (left < right && nums[left] < pivot) {
                left++;
            }
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            swap(nums, left, right);
            if (left >= right) {
                if (nums[right] > pivot) {
                    right--;
                }
                swap(nums, right, start);
                return right;
            }
        }
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = hpartition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    public int quickSelect(int[] nums, int k, int start, int end) {
        int index = partition(nums, start, end);
        if (index == k - 1) {
            return nums[index];
        } else if (index > k - 1) {
            return quickSelect(nums, k, start, index - 1);
        } else {
            return quickSelect(nums, k, index + 1, end);
        }
    }

    public void swim(int[] nums, int index) {
        if (index == 0){
            return;
        } else {
            int parent = index/2;
            if (nums[parent] < nums[index]) {
                swap(nums, parent, index);
                return;
            }
        }
    }

    public void heapify(int[] nums, int start, int end) {
        for (int i = end; i > start; i--) {
            swim(nums, i);
        }
    }

    public void heapSort(int[] nums) {
        heapify(nums, 0, nums.length - 1);
        int index = nums.length - 1;
        while (index > 0) {
            swap(nums, index, 0);
            index--;
            heapify(nums, 0, index);
        }
    }

    public int[] countSort(int[] nums) {
        int[] counts = new int[nums.length];
        int[] startPos = new int[nums.length];
        startPos[0] = 0;
        int[] sorted = new int[nums.length];
        for (int num: nums) {
            counts[num] += 1;
        }
        for (int i = 1; i < nums.length; i++) {
            startPos[i] = counts[i-1] + startPos[i - 1];
        }
        for (int num: nums) {
            sorted[startPos[num]] = num;
            startPos[num] += 1;
        }
        return sorted;
    }

    private int getMax(int[]  nums) {
        int max = 0;
        for (int num: nums) {
            max = num > max ? num : max;
        }
        return max;
    }

    private void bucketSort(int[] nums, int scale) {
        int[] count = new int[10];
        int[] startPos = new int[10];
        int[] out = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[(nums[i]/scale)%10] += 1;
        }

        for (int i = 1; i < count.length; i++) {
            startPos[i] = startPos[i - 1] + count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            out[startPos[(nums[i]/scale)%10]] = nums[i];
            startPos[(nums[i]/scale)%10] += 1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = out[i];
        }
    }

    public void LSDRadixSort(int[] nums) {
        int maxNum = getMax(nums);
        for (int i = 1; maxNum/i > 0; i*=10) {
            bucketSort(nums, i);
        }
    }
}
