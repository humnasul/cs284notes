import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticTest {

    @Test
    public void testAddition() {
        Arithmetic calculator = new Arithmetic();
        assertEquals(4, calculator.addition(2,2));
    }
}
