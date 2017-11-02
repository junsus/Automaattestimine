package files;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteReadFile {

    public static void writeToFile(String file, String output) {
        try {
            PrintWriter writer = new PrintWriter(
                    "C:/Users/arf/IdeaProjects/Automaattestimine/praks3/src/" + file, "UTF-8");
            writer.write(output);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String file) {
        try {
            Scanner in = new Scanner(new FileReader(
                    "C:/Users/arf/IdeaProjects/Automaattestimine/praks3/src/" + file));
            StringBuilder builder = new StringBuilder();
            while (in.hasNext()) {
                builder.append(in.next());
            }
            in.close();
            return builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
