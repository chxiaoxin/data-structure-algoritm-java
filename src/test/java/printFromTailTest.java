import org.junit.Assert;
import org.junit.Test;

public class printFromTailTest {
    @Test
    public void printFromTailTest() {
        PrintLinkedListFromTail print = new PrintLinkedListFromTail();
        int[] result = print.printFromTail(new int[]{1,2,3,4,5,6});
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6}, result);
    }
}
