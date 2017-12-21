package files;

import java.io.PrintWriter;
import java.util.Scanner;

public class WriteReadFile {

    public void writeToFile(String fileName, String output) {
        try {
            PrintWriter writer = new PrintWriter(
                    fileName, "UTF-8");
            writer.write(output);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(String fileName) {
        try {
            Scanner in = new Scanner(WriteReadFile.class.getResourceAsStream(fileName));
            StringBuilder builder = new StringBuilder();
            while (in.hasNext()) {
                builder.append(in.next() + "\n");
            }
            in.close();
            return builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
