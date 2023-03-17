package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class ReadObjectBinary_Pt3 {
    private FileInputStream fis;
	private ObjectInputStream ois;
	
	public ReadObjectBinary_Pt3(File file) throws IOException {
		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
	}
	
	public Object readObject() throws ClassNotFoundException, IOException {
		return ois.readObject();
	}
	
	public void cleanUp() throws IOException {
		ois.close();
	}
}
