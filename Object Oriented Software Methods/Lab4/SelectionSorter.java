package Lab4;

public class SelectionSorter extends Sorter{

   @Override
   public void sort(Double[] values) {
      for (int i = 0; i < values.length - 1; i++)
      {
         int minPos = i;
         for (int j = i + 1; j < values.length; j++)
         {
            if (values[j] < values[minPos])
               minPos = j;
            pause((double) minPos, (double)j);
         }
         pause((double)minPos, (double)i);
         swap(minPos, i);
      }
   }
}
