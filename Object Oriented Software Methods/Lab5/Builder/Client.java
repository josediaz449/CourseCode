package Lab5.Builder;

public class Client {
    
    public static void main(String[] args) {
        AbstractCar car = new Saloon(new StandardEngine(1300));
        VehicleBuilder builder = new CarBuilder(car);
        VehicleDirector director = new CarDirector();
        Vehicle v = director.build(builder);
        System.out.println(v);
    }
    
}
