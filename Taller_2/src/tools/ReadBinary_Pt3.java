package tools;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadBinary_Pt3 {
    private File file;
	private FileInputStream fis;
    private DataInputStream dis;

    public ReadBinary_Pt3(File file) throws FileNotFoundException {
        fis = new FileInputStream(file);
        dis = new DataInputStream(fis);
    }

    public String readLines() throws IOException {
        String content = "";
        while(fis.available() > 0) {
            content += dis.readUTF();
        }
        return content;
    }

    public void cleanUp() throws IOException {
        dis.close();
    }
}
