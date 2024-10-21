import org.example.Calculator.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void testAddWhenInputIsEmpty(){

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("");
        assertEquals(0, result);
    }

    @Test
    public void testAddWhenInputHasSingleOperand(){

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("1");
        assertEquals(1,result);
    }

    @Test
    public void testAddWhenInputHasMultipleOperand(){
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("1,2,3,4");
        assertEquals(10,result);
    }

    @Test
    public void testAddWhenInputHasMultipleOperandsAndMultipleDelimiters(){
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void testAddWhenInputHasCustomDelimitersAndMultipleOperands(){
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("//;\n1;2;3");
        assertEquals(6, result);
    }
}
