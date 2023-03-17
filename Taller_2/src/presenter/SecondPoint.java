package presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import tools.ReadBinaryFiles;
import tools.ReadTextFiles;
import tools.WriteBinaryFiles;
import tools.WriteTextFiles;
import view.SecondPointView;

public class SecondPoint {
    private String binaryFilePath;
    private String textFilePath;
    private SecondPointView view;
    private ReadBinaryFiles readBin;
    private ReadTextFiles readTxt;
    private String sourcePath;
    private int selectedType;
    private boolean isClear;
    private WriteBinaryFiles writeBin;
    private WriteTextFiles writeText;

    public SecondPoint() throws FileNotFoundException {
        view = new SecondPointView();
        askForInfo();
        readBin = new ReadBinaryFiles(binaryFilePath);
        readTxt = new ReadTextFiles(textFilePath);
    }

    private String readBinFile() throws IOException {
        return readBin.readLines();
    }

    private String readTxtFile() throws IOException {
        return readTxt.readLines();
    }

    private void askForInfo() {
        binaryFilePath = view.askForBinPath(Constants_Pt2.ASKFORBINPATH);
        textFilePath = view.askForTxtPath(Constants_Pt2.ASKFORTXTPATH);
        sourcePath = view.askForSourcePath(Constants_Pt2.ASKFORSOURCEPATH);
        selectedType = view.askForSourceFileType(Constants_Pt2.ASKFORFILETYPE);
        isClear = view.askIfUserWantToClear(Constants_Pt2.ASKFORCLEAR);
    }

    public String obtainSourceFileName(String path) {
        String newPath = "";
        
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 92) {
                newPath += "/";
            } else {
                newPath += path.charAt(i);
            }
        }

        String[] miniArray = newPath.split("/");
        String auxName = miniArray[miniArray.length - 1];
        String[] name = auxName.split("\\.");
        return name[0];
    }

    private String sourceFileName() {
        String binName = obtainSourceFileName(binaryFilePath);
        String txtName = obtainSourceFileName(textFilePath);
        return "\\" + binName + "-" + txtName + Constants_Pt2.OPTIONS[selectedType];
    }

    private String contentNewFile() throws IOException {
        String binContent = readBinFile();
        String txtContent = readTxtFile();
        return binContent + txtContent;
    }

    private void writeNewFile() throws IOException {
        String content = contentNewFile();
        sourcePath = sourcePath + sourceFileName();
        if (selectedType == 0) {
            if (isClear) {
                writeBin = new WriteBinaryFiles(sourcePath, isClear);
                writeBin.writeFile(content);
            } else {
                writeBin = new WriteBinaryFiles(sourcePath, false);
                writeBin.writeFile(content);
            }
        } else {
            if (isClear) {
                writeText = new WriteTextFiles(sourcePath, isClear);
                writeText.writeFile(content);
                writeText.cleanUp();
            } else {
                writeText = new WriteTextFiles(sourcePath, false);
                writeText.writeFile(content);
                writeText.cleanUp();
            }
        }
    }

    private void run() throws IOException {
        writeNewFile();
    }

    public static void main(String[] args) throws IOException {
        SecondPoint sp = new SecondPoint();
        sp.run();
    }

}
