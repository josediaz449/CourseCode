package Lab2.Ex13;

import java.io.IOException;
import java.io.Writer;

public class EncryptingWriter extends Writer {
   private Writer writer;
   public EncryptingWriter(Writer writer){
      this.writer=writer;
   }
   @Override
   public void write(char[] cbuf, int off, int len) throws IOException {

   }

   @Override
   public void flush() throws IOException {
      this.writer.flush();
   }

   @Override
   public void close() throws IOException {
      this.writer.close();
   }
}
