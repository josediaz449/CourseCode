package Lab5.Prototype;

public class Sport extends AbstractCar {
    
    public Sport(Engine engine) {
        this(engine, Vehicle.Colour.UNPAINTED);
    }
    
    public Sport(Engine engine, Vehicle.Colour colour) {
        super(engine, colour);
    }
    
}
