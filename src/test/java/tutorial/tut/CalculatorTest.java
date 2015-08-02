package tutorial.tut;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tutorial.tut.Calculator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Sidhavratha on 25/7/15.
 */
public class CalculatorTest {

    @Mock
    private Calculator calc;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAbs()
    {
        when(calc.abs(-20)).thenReturn(20);
        when(calc.abs(-1)).thenReturn(1);
        assertEquals(20,calc.abs(-20));
        assertEquals(1,calc.abs(-1));
    }
}
