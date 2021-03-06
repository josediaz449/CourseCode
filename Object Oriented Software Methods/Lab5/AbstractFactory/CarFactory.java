package Lab5.AbstractFactory;

public class CarFactory extends AbstractVehicleFactory{
   public Body createBody() {
      return new CarBody();
   }

   public Chassis createChassis() {
      return new CarChassis();
   }

   public Windows createWindows() {
      return new CarWindows();
   }
}
