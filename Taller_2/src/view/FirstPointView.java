package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FirstPointView {
	private Icon files;

	public FirstPointView() {
		files = new ImageIcon("icons/escritura.png");
	}

    public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Resultado", JOptionPane.DEFAULT_OPTION, files);
	}

}
