package presenter;

import java.io.File;
import java.io.IOException;

import model.Vehicle;
import tools.ReadBinary_Pt3;
import tools.ReadObjectBinary_Pt3;
import tools.WriteBinary_Pt3;
import tools.WriteObjectBinary_Pt3;
import view.ThirdPointView;

public class ThirdPoint {
    private ThirdPointView view;
	private WriteBinary_Pt3 write;
	private ReadBinary_Pt3 read;
	private Vehicle vehicle;
	private File file;
	private WriteObjectBinary_Pt3 wob;
	private ReadObjectBinary_Pt3 rob;
	
	public ThirdPoint() throws IOException {
		view = new ThirdPointView();
	}
	
	private int generateId() throws NumberFormatException, IOException {
		int id = 0;
		file = new File(Constants_Pt3.PATH_VEHICLE_SEQUENCE);
		if (!file.exists()) {
			id = 1;
		} else {
			read = new ReadBinary_Pt3(file);
			id = Integer.parseInt(read.readLines());
			id++;
		}
		write = new WriteBinary_Pt3(file);
		write.writeFile(id + "");
		write.cleanUp();
		return id;
	}
	
	private void createVehicle() throws IOException {
		String brand = view.readData(Constants_Pt3.ASK_FOR_BRAND);
		String model = view.readData(Constants_Pt3.ASK_FOR_MODEL);
		int year = view.readInt(Constants_Pt3.ASK_FOR_YEAR);
		String licensePlate = view.readData(Constants_Pt3.ASK_FOR_LICENSE_PLATE);
		String color = view.readData(Constants_Pt3.ASK_FOR_COLOR);
		int id = generateId();
		
		vehicle = new Vehicle(id, brand, model, year, licensePlate, color);
		wob = new WriteObjectBinary_Pt3(Constants_Pt3.PATH_NEW_VEHICLE + "vehicle_" + id + ".veh");
		wob.writeObject(vehicle);
		wob.cleanUp();
	}
	
	private String showAllVehicles() throws ClassNotFoundException, IOException {
		int n = 1;
		String content = "";
		
		while((file = new File(Constants_Pt3.PATH_NEW_VEHICLE + "vehicle_" + n + ".veh")).exists()) {
			rob = new ReadObjectBinary_Pt3(file);
			vehicle = (Vehicle) rob.readObject();
			content += vehicle.toString() + "\n";
			n++;
		}
		
		return content;
	}
	
	private String showVehicleById(int id) throws IOException, ClassNotFoundException {
		String result = "";
		if ((file = new File(Constants_Pt3.PATH_NEW_VEHICLE + "vehicle_" + id + ".veh")).exists()) {
			rob = new ReadObjectBinary_Pt3(file);
			vehicle = (Vehicle) rob.readObject();
			result = vehicle.toString();
		} else {
			result = "No existe un vehiculo con ese id";
		}
		
		return result;
	}
	
	private void firstDecision() throws NumberFormatException, IOException, ClassNotFoundException {
		int option = 0;
		do {
			option = view.firstMenu();
			switch (option) {
			case 1:
				createVehicle();
				view.showMessage(Constants_Pt3.CONFIRMATION_MSG);
				break;
			case 2:
				view.showMessage(showAllVehicles());
				break;
			case 3:
				int id = view.readInt(Constants_Pt3.SEARCH_BY_ID);
				view.showMessage(showVehicleById(id));
				break;
			case 4:
				view.showMessage(Constants_Pt3.GOODBYE_MSG);
				System.exit(0);
				break;
			default:
				view.showMessage(Constants_Pt3.ALERT_MSG);
				firstDecision();
		}
		} while (option != 4);
	}
	
	private void run() throws NumberFormatException, IOException, ClassNotFoundException {
		firstDecision();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException {
		ThirdPoint main = new ThirdPoint();
		main.run();
	}
}
