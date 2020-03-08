package Lab5.FactoryMethod;

public class Coupe extends AbstractCar {

    public Coupe(Engine engine) {
        this(engine, Vehicle.Colour.UNPAINTED);
    }
    
    public Coupe(Engine engine, Vehicle.Colour colour) {
        super(engine, colour);
    }
    
}
