package Lab2.Ex13;

import java.io.IOException;
import java.io.Reader;

public class DecryptingReader extends Reader {
   private Reader reader;
   public DecryptingReader(Reader reader){
      this.reader=reader;
   }
   @Override
   public int read(char[] cbuf, int off, int len) throws IOException {
      return 0;
   }

   @Override
   public void close() throws IOException {
      this.reader.close();
   }
}
