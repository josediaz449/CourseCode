package HW7;


public class AbstractStove implements Stove{
   private int energy;
   private boolean isEfficient;
   private boolean isOn;
   private int temp;

   public AbstractStove(int energy, boolean isEfficient){
      this.energy=energy;
      this.isEfficient=isEfficient;
      this.isOn=false;
      this.temp=0;
   }
   @Override
   public int getEnergyUsage() {
      return this.energy;
   }

   @Override
   public boolean isEfficient() {
      return this.isEfficient;
   }

   @Override
   public void turnOn() {
      this.isOn=true;
      this.temp=50;
      System.out.println("Stove is On");
   }

   @Override
   public void turnOff() {
      isOn=false;
      this.temp=0;
      System.out.println("Stove is off");
   }

   @Override
   public void increaseTemp() {
      temp+=5;
      System.out.println("Stove temp increased to " + this.temp);
   }

   @Override
   public void decreaseTemp() {
      temp-=5;
      System.out.println("Stove temp decreased to " + this.temp);
   }
}
