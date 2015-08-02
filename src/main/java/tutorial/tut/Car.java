package tutorial.tut;

/**
 * Created by Sidhavratha on 25/7/15.
 */
public class Car {

    private Engine engine;
    private String warningMessage;

    public Car(Engine engine)
    {
        this.engine = engine;
    }

    public void accelerate()
    {
        engine.increaseRpm();
        if(engine.getRpm()>5000)
        {
            this.warningMessage="Slow down";
        }
    }

    public String getWarningMessage()
    {
        return this.warningMessage;
    }

}
