
package Lab5.Builder;

public class VanBuilder extends VehicleBuilder {
    
    private AbstractVan vanInProgress;
    
    public VanBuilder(AbstractVan van) {
        vanInProgress = van;
    }
    
    public void buildBody() {
        // Add body to vanInProgress
        System.out.println("Building van body");
    }
    
    public void buildChassis() {
        // Add chassis to vanInProgress
        System.out.println("Building van chassis");
    }
    
    public void buildReinforcedStorageArea() {
        // Add storage area to vanInProgress
        System.out.println("Building van passenger area");
    }
    
    public void buildWindows() {
        // Add windows to vanInProgress
        System.out.println("Building van windows");
    }

    public Vehicle getVehicle() {
        return vanInProgress;
    }
    
}
