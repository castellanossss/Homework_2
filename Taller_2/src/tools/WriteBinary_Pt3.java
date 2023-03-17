package tools;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinary_Pt3 {
    private File file;
    private FileOutputStream fos;
    private DataOutputStream dos;

    public WriteBinary_Pt3(File file) throws FileNotFoundException {
        fos = new FileOutputStream(file);
        dos = new DataOutputStream(fos);
    }

    public void writeFile(String content) throws IOException {
        dos.writeUTF(content);
    }
    
    public boolean checkIfExist() {
    	return file.exists();
    }

    public void cleanUp() throws IOException {
        dos.close();
    }
}
