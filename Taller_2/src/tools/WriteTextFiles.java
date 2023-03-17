package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteTextFiles {
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;

    public WriteTextFiles(String path, boolean decision) throws IOException {
        file = new File(path);
        fw = new FileWriter(file, decision);
        bw = new BufferedWriter(fw);
    }

    public void writeFile(String content) throws IOException {
        bw.write(content + "\n");
    }

    public void cleanUp() throws IOException {
        bw.close();
    }

}
