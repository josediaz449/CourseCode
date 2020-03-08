package Lab4;
public abstract class Sorter implements Runnable
{
   public void setValues(Double[] values)
   {
      this.values = values;
   }

   /**
    Sets the panel for this sorter.
    @param panel the panel for showing the sort animiation
    */
   public void setPanel(ArrayComponent panel)
   {
      this.panel = panel;
   }


   /**
    Sorts the array managed by this Sorter.
    */
   public abstract void sort(Double[] values);

   /**
    Either waits for the gate to open or sleeps, depending on the
    current state of the gate.  Then displays the current state of the sort.
    */
   private Double[] values;
   private ArrayComponent panel;
   private static final int DELAY = 100;

   public void pause(Double marked1, Double marked2)
   {
      panel.setValues(values, marked1, marked2);
      try
      {
         Thread.sleep(DELAY);
      }
      catch (InterruptedException exception)
      {
         Thread.currentThread().interrupt();
      }
   }

   public void swap(int i, int j)
   {
      Double temp = values[i];
      values[i] = values[j];
      values[j] = temp;
   }

   public void run()
   {
      sort(values);
   }
}
