import org.example.Calculator.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void testAddWhenInputIsEmpty() throws Exception {

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("");
        assertEquals(0, result);
    }

    @Test
    public void testAddWhenInputHasSingleOperand() throws Exception {

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("1");
        assertEquals(1,result);
    }

    @Test
    public void testAddWhenInputHasMultipleOperand() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("1,2,3,4");
        assertEquals(10,result);
    }

    @Test
    public void testAddWhenInputHasMultipleOperandsAndMultipleDelimiters() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void testAddWhenInputHasCustomDelimitersAndMultipleOperands() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//;\n1;2;3");
        assertEquals(6, result);
    }

    @Test
    public void testAddWhenInputHasNegativeNumbers(){
        StringCalculator stringCalculator = new StringCalculator();
        Exception exception = assertThrows(Exception.class, () -> stringCalculator.Add("//;\n-1;-2;3"));

        assertEquals("Negatives are not allowed. Please remove the following numbers: [-1, -2]", exception.getMessage());
    }

    @Test
    public void testAddWhenInputHasMultipleDelimitersWithDifferentLengths() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//[**][%%]\n1**2%%3");
        assertEquals(6, result);
    }
}
