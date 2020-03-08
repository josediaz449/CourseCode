package HW8;

import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

public class AdaptorReaderIterator implements Iterable<Integer> {
   private Scanner sc;
   AdaptorReaderIterator(Reader in)
   {
      this.sc = new Scanner(in);
   }

   public Iterator<Integer> iterator()
   {
      return new Itr();
   }

   private class Itr implements Iterator<Integer>
   {
      public boolean hasNext()
      {
         return sc.hasNextInt();
      }
      public Integer next()
      {
         return sc.nextInt();
      }
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
}
