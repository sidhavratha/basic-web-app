package tutorial.tut;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tutorial.tut.Car;
import tutorial.tut.Engine;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Sidhavratha on 25/7/15.
 */
public class CarTest {

    @Mock
    private Engine engine;

    @InjectMocks
    private Car car;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWarning()
    {
        when(engine.getRpm()).thenReturn(6000);
        car.accelerate();
        assertEquals("Slow down", car.getWarningMessage());
    }

    @Test
    public void testAccelerate()
    {

    }
}
