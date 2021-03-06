
package Lab5.AbstractFactory;

public class VanFactory extends AbstractVehicleFactory {

    public Body createBody() {
        return new VanBody();
    }

    public Chassis createChassis() {
        return new VanChassis();
    }

    public Windows createWindows() {
        return new VanWindows();
    }
    
}
