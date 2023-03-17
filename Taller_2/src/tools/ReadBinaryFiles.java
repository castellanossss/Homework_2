package tools;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadBinaryFiles {
    private FileInputStream fis;
    private DataInputStream dis;

    public ReadBinaryFiles(String path) throws FileNotFoundException {
        fis = new FileInputStream(path);
        dis = new DataInputStream(fis);
    }

    public String readLines() throws IOException {
        String content = "";
        while(fis.available() > 0) {
            content += dis.readUTF() + "\n";
        }
        return content;
    }

    public void cleanUp() throws IOException {
        dis.close();
    }

}
