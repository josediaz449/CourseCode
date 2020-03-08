package Lab5.FactoryMethod;

public class Client {
    
    public static void main(String[] args) {
        // I want an economical car, coloured blue...
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.build
                (VehicleFactory.DrivingStyle.ECONOMICAL,
                 Vehicle.Colour.BLUE);
        System.out.println(car);
        
        // I am a "white van man"...
        VehicleFactory vanFactory = new VanFactory();
        Vehicle van = vanFactory.build
                (VehicleFactory.DrivingStyle.POWERFUL,
                 Vehicle.Colour.WHITE);
        System.out.println(van);
        
        // Create a red sports car...
        Vehicle sporty = VehicleFactory.make
                                (VehicleFactory.Category.CAR,
                                 VehicleFactory.DrivingStyle.POWERFUL,
                                 Vehicle.Colour.BLUE);
        System.out.println(sporty);
    }
    
}
