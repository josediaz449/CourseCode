package Lab4;

public class BubbleSorter extends Sorter {
   @Override
   public void sort(Double[] values) {
      for (int i = 0; i < values.length; i++)
      {
         for (int j = 0; j < values.length - 1; j++)
         {
            pause((double)j, (double)j + 1);
            if (values[j] > values[j + 1])
               swap(j, j + 1);
         }
      }
   }
}
