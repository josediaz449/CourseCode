package Lab2.Ex12;

import Lab2.Ex13.CaesarCipher;

import java.io.IOException;
import java.io.Reader;

public class DecryptingReader extends Reader {
   private Reader reader;
   static final int CAESAR_OFFSET = 3;
   static final int ALPHABET_SIZE = 26;

   public DecryptingReader(Reader reader){
      this.reader=reader;
   }
   @Override
   public int read(char[] charBuffer, int offset, int length) throws IOException {
      int result = reader.read(charBuffer,offset,length);
      CaesarCipher caesarCipher = new CaesarCipher();
      caesarCipher.decrypt(charBuffer, offset, length);
      return result;
   }

   @Override
   public void close() throws IOException {
      reader.close();
   }
}
