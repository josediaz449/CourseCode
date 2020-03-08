package Lab5.AbstractFactory;

public class Client {
   public static void main(String[] args) {
      String whatToMake = "car"; // or "van"

      AbstractVehicleFactory factory = null;

      // Create the correct 'factory'...
      if (whatToMake.equals("car")) {
         factory = new CarFactory();
      } else {
         factory = new VanFactory();
      }

      // Create the vehicle's component parts...
      // These will either be all car parts or all van parts.
      Body vehicleBody = factory.createBody();
      Chassis vehicleChassis = factory.createChassis();
      Windows vehicleWindows = factory.createWindows();

      // Show what we've created...
      System.out.println(vehicleBody.getBodyParts());
      System.out.println(vehicleChassis.getChassisParts());
      System.out.println(vehicleWindows.getWindowParts());
   }
}
