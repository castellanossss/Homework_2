package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderManager_1 {
    private File file;
    private FileReader fr;
    private BufferedReader br;

    public FileReaderManager_1(String path, String name) throws FileNotFoundException {
        file = new File(path + name + ".txt");
        fr = new FileReader(file);
        br = new BufferedReader(fr);
    }

    public String readFile() throws IOException {
        String line = br.readLine();
        return line;
    }

    public void cleanUp() throws IOException {
        if (br != null) {
            br.close();
        }
    }

}