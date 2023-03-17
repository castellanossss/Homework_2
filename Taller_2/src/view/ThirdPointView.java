package view;

import javax.swing.JOptionPane;

public class ThirdPointView {
    public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
		
	public String readData(String message) {
		String data = JOptionPane.showInputDialog(null, message);
		return data;
	}
	
	public int readInt(String message) {
		int input = Integer.parseInt(readData(message));
		return input;
	}
		
	public int firstMenu() {
		int option = Integer.parseInt(readData("Selecciona una opcion\n1. Crear un nuevo vehiculo \n2. Encontrar un vehiculo \n3. Encontrar un vehiculo por id\n4. Salir"
				+ "\nDigite una opcion"));
		return option;
	}
}
