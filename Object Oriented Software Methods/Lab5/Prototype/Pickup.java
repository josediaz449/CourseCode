package Lab5.Prototype;

public class Pickup extends AbstractVan {
    
    public Pickup(Engine engine) {
        this(engine, Vehicle.Colour.UNPAINTED);
    }
    
    public Pickup(Engine engine, Vehicle.Colour colour) {
        super(engine, colour);
    }
    
}
