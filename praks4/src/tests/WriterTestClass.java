package tests;

import files.WriteReadFile;

public class WriterTestClass {
    private WriteReadFile writeReadFile;

    public WriterTestClass(WriteReadFile writeReadFile) {
        this.writeReadFile = writeReadFile;
    }

    public void readFile(String fileName) {
        writeReadFile.readFile(fileName);
    }

    public void writeFile(String fileName, String output) {
        writeReadFile.writeToFile(fileName, output);
    }
}
