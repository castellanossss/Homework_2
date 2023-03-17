package presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import tools.FileReaderManager_1;
import view.FirstPointView;

public class FirstPoint {
    private final String FILEPATH = "data/input/";
    private final String FILENAME = "firstPoint";

    private FileReaderManager_1 frm;
    private FirstPointView view;

    public FirstPoint() throws FileNotFoundException {
        frm = new FileReaderManager_1(FILEPATH, FILENAME);
        view = new FirstPointView();
    }

    public void result() throws IOException {
        String line = frm.readFile();
        String result = "";

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != 32) {
                result += line.charAt(i);
            }
        }

        view.showMessage(result);
    }

    private void run() throws IOException {
        result();
    }

    public static void main(String[] args) throws IOException {
        FirstPoint runner = new FirstPoint();
        runner.run();
    }
}
