import org.junit.Assert;
import org.junit.Test;

public class fibonacciTest {
    @Test
    public void fibonacciTest() {
        int result = Fibonacci.fibonacci(8);
        Assert.assertEquals(34, result);
    }
}
