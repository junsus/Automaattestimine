package tests;

import files.WriteReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WriteReadFileTest {

    @Test
    public void writeReadFile() {
        WriteReadFile.writeToFile("testwriter.txt", "test123");
        assertEquals("test123", WriteReadFile.readFile("testwriter.txt"));
    }

    @Test
    public void writeReadFile2() {
        WriteReadFile.writeToFile("testwriter.txt", "123test");
        assertEquals("123test", WriteReadFile.readFile("testwriter.txt"));
    }
}
