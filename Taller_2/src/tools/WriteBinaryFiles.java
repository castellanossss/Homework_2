package tools;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinaryFiles {
    private File file;
    private FileOutputStream fos;
    private DataOutputStream dos;

    public WriteBinaryFiles(String path, boolean decision) throws FileNotFoundException {
        file = new File(path);
        fos = new FileOutputStream(file, decision);
        dos = new DataOutputStream(fos);
    }

    public void writeFile(String content) throws IOException {
        dos.writeUTF(content);
    }

    public void cleanUp() throws IOException {
        dos.close();
    }

}
