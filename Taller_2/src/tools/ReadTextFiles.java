package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFiles {
    private File file;
    private FileReader fr;
    private BufferedReader br;

    public ReadTextFiles(String path) throws FileNotFoundException {
        file = new File(path);
        fr = new FileReader(file);
        br = new BufferedReader(fr);
    }

    public String readLines() throws IOException {
        String finalText = "";
        String line;

        while ((line = br.readLine()) != null) {
            finalText += line + "\n";
        }

        return finalText;
    }

    public void cleanUp() throws IOException {
        if (br != null) {
            br.close();
        }
    }


}
