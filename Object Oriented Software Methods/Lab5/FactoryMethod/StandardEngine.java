package Lab5.FactoryMethod;

public class StandardEngine extends AbstractEngine {

    public StandardEngine(int size) {
        super(size, false); // not turbocharges
    }
    
}
