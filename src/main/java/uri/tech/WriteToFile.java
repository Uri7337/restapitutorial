package uri.tech;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

public class WriteToFile {
  void writeToFile(String fileName, String fileContent) {
    CreateFile cf = new CreateFile();
    cf.createfile(fileName);

    try {
      FileWriter myWriter = new FileWriter("test/"+fileName+".jpeg");
      myWriter.write(fileContent);
      myWriter.close();  // must close manually
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
