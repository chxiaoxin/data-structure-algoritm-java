import org.junit.Assert;
import org.junit.Test;

public class twoDimensionalSearchTest {

    @Test
    public void testSearch() {
        int[][] array = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Assert.assertEquals(true, TwoDimensionalSearch.search(array, 10));
        Assert.assertEquals(true, TwoDimensionalSearch.search(array, 16));
        Assert.assertEquals(true, TwoDimensionalSearch.search(array, 1));
        Assert.assertEquals(false, TwoDimensionalSearch.search(array, 100));
    }

}
