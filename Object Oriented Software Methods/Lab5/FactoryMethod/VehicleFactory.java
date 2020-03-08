package Lab5.FactoryMethod;

public abstract class VehicleFactory {
    
    public enum Category {CAR, VAN}
    public enum DrivingStyle {ECONOMICAL, MIDRANGE, POWERFUL};
    
    public static Vehicle make(Category category,
                               DrivingStyle style,
                               Vehicle.Colour colour) {
        VehicleFactory factory = null;
        
        if (category == Category.CAR) {
            factory = new CarFactory();
        } else {
            factory = new VanFactory();
        }
        
        return factory.build(style, colour);
    }
    
    public Vehicle build(DrivingStyle style, Vehicle.Colour colour) {
        Vehicle v = selectVehicle(style);
        v.paint(colour);
        return v;
    }
    
    // This is the "factory method"
    protected abstract Vehicle selectVehicle(DrivingStyle style);
    
}
