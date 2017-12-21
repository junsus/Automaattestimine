package tests;

import files.WriteReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WriteReadFileTest {

    private WriteReadFile writeReadFile = mock(WriteReadFile.class);
    private WriterTestClass writerTestClass;

    @BeforeEach
    public void beforeEachTest() {
         writerTestClass = new WriterTestClass(writeReadFile);
    }

    @Test
    public void mockReadFile() {
        writerTestClass.readFile("test.txt");
        verify(writeReadFile).readFile("test.txt");
    }

    @Test
    public void mockWriteFile() {
        writerTestClass.writeFile("test.txt", "test123");
        verify(writeReadFile).writeToFile("test.txt", "test123");
    }
}
