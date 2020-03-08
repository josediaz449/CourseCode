package HW7;

public class AbstractStoveControls {
   private Stove stove;
   public AbstractStoveControls(Stove stove) {
      this.stove = stove;
   }

   public void stoveOn() {
      stove.turnOn();
   }

   public void stoveOff() {
      stove.turnOff();
   }

   public void turnKnobLeft() {
      stove.increaseTemp();
   }

   public void turnKnobRight() {
      stove.decreaseTemp();
   }
}
