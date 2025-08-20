import java.io.*;
import java.util.Scanner;

class encrypt {
  public static void main(String[] args) throws IOException {
    FileReader reader = new FileReader("decrypt.txt");
    FileWriter writer = new FileWriter("encrypt.txt");
   
    int character;

    while ((character = reader.read()) != -1) {
      character += 3;
      writer.write((char) character);
    }
    reader.close();
    writer.close();
  }
}
