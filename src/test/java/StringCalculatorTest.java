import org.example.Calculator.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void testAdd(){

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.Add("1,2,3");
        assertEquals(0, result);
    }
}
