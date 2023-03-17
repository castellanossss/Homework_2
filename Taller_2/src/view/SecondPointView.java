package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import presenter.Constants_Pt2;

public class SecondPointView {
    private Icon text, binary, source, clear, type;

    public SecondPointView() {
        text = new ImageIcon("icons/text.png");
        binary = new ImageIcon("icons/binary.png");
        source = new ImageIcon("icons/source.png");
        clear = new ImageIcon("icons/clear.png");
        type = new ImageIcon("icons/type.png");
    }

    public String askForBinPath(String message) {
        String binPath = (String) JOptionPane.showInputDialog(null, message, 
        "Por favor, digita bien la ruta", JOptionPane.PLAIN_MESSAGE, binary, null,
        null);
        return binPath;
    }

    public String askForTxtPath(String message) {
        String textPath = (String) JOptionPane.showInputDialog(null, message, "Por favor, digita bien la ruta", JOptionPane.PLAIN_MESSAGE, text, null, null);
        String newPath = textPath.replace("?", "");
        return newPath;
    }

    public String askForSourcePath(String message) {
        String sourcePath = (String) JOptionPane.showInputDialog(null, message, "Por favor, digita bien la ruta", JOptionPane.PLAIN_MESSAGE, source, null, null);
        return sourcePath;
    }

    public int askForSourceFileType(String message) {
        Object[] options = {Constants_Pt2.OPTIONS[0], Constants_Pt2.OPTIONS[1]};
        int selectedOption = JOptionPane.showOptionDialog(null, message, "Selecciona una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, type, options, options[0]);
        return selectedOption;
    }

    public boolean askIfUserWantToClear(String message) {
        int opcion = JOptionPane.showConfirmDialog(null, message, "¿Limpieza?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, clear);

        boolean decision = true;
        if (opcion == JOptionPane.YES_OPTION) {
            decision = false;
        }

        return decision;
    }

}
