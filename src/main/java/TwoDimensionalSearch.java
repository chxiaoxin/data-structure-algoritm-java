public class TwoDimensionalSearch {

    public static boolean search(int[][] array, int target) {
        int row = 0;
        int column = array[0].length - 1;
        while (row < array.length && column > -1) {
            if (array[row][column] > target) {
                column--;
            } else if (array[row][column] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
