package HW7;

public class Client {
   public static void main(String[] args) {
      Stove stove = new StandardStove(1300);
      StandardControls standardControls = new StandardControls(stove);
      standardControls.stoveOn();
      standardControls.turnKnobLeft();
      standardControls.turnKnobRight();
      standardControls.stoveOff();

      Stove stove1 = new EfficientStove(1000);
      EfficientStoveControls efficientStoveControls = new EfficientStoveControls(stove1);
      efficientStoveControls.stoveOn();
      efficientStoveControls.turnKnobLeft();
      efficientStoveControls.turnKnobLeft();
      efficientStoveControls.stoveOff();


   }
}
