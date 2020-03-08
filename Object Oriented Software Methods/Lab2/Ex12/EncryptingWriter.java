package Lab2.Ex12;

import Lab2.Ex13.CaesarCipher;

import java.io.IOException;
import java.io.Writer;

public class EncryptingWriter extends Writer {

   private Writer writer;
   static final int CAESAR_OFFSET = 3;
   static final int ALPHABET_SIZE = 26;

   public EncryptingWriter(Writer writer){
      this.writer=writer;
   }

   @Override
   public void write(char[] charBuffer, int offset, int length) throws IOException {
      CaesarCipher caesarCipher = new CaesarCipher();
      caesarCipher.encrypt(charBuffer, offset, length);
      writer.write(charBuffer,offset,length);
   }

   @Override
   public void flush() throws IOException {
      writer.flush();
   }

   @Override
   public void close() throws IOException {
      writer.close();
   }
   public Writer getWriter() {
      return writer;
   }
}
