package HW8;

import java.io.StringReader;

public class AdaptorMain {
   public static void main(String[] args) {
      AdaptorReaderIterator adaptorReaderIterator = new AdaptorReaderIterator(new StringReader("1 2 6 12 100"));
      for (Integer i : adaptorReaderIterator) {
         System.out.println(i);
      }

   }
}
