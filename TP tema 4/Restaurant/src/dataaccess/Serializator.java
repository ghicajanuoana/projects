package dataaccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializator {
    
	public static void writeToFile(String file,Object object) throws IOException {  //serializarea delivery service
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOut);
        try {
        objectOutput.writeObject(object);
        objectOutput.flush();
        objectOutput.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
	}
    public static Object readFile(String file) throws IOException {   
    FileInputStream fileInputStream = new FileInputStream(file);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    Object obj = null;
	try {
		obj = objectInputStream.readObject();
		objectInputStream.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;
	}
    
    
}
