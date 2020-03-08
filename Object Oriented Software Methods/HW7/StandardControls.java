package HW7;

public class StandardControls extends AbstractStoveControls {
   public StandardControls(Stove stove) {
      super(stove);
   }
   public void turnKnobLeft(){
      super.turnKnobLeft();
      super.turnKnobLeft();
   }
}
