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
    public void testAddWhenInputHasMultipleOperandsAndStandardDelimiters() throws Exception {
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
    public void testAddWhenInputHasNumbersLargerThan1000() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//;\n1;2;3;1005;35");
        assertEquals(41,result);
    }

    @Test
    public void testAddWhenInputHasSingleDelimiterWithLengthMoreThanOne() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//[*****][%]\n1*****2*****3");
        assertEquals(6, result);
    }

    @Test
    public void testAddWhenInputHasMultipleDelimiters() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @Test
    public void testAddWhenInputHasMultipleDelimitersWithDifferentLengths() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//[**][%%]\n1**2%%3");
        assertEquals(6, result);
    }


    @Test
    public void testAddWhenInputHasMultipleDelimitersWithDifferentLengthsAndNumbersLargerThan1000() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//[**][%%]\n1**2%%3**1005");
        assertEquals(6, result);
    }

    // Additional Testcases


}
