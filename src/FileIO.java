import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.ViewController;

public class FileIO {

	public static void saveToFile(byte[] b) {
		try {
			FileOutputStream fos = new FileOutputStream("/Portfolio"); 
			fos.write(b);
		} catch (Exception e) {
			//TODO:Do something
		}
	}
	
//	public static byte[] loadFromFile(String pathname) {
//		FileInputStream fis;
//		try { 
//			fis = new FileInputStream(pathname);
//			while(fis.read() != -1);
//		} catch (Exception e) {
//			//TODO: do something
//		} finally {
//			return fis.toString();
//		}
//		 
//	}
	
	
    public static byte[] getByteArrayObject(ViewController vc){
        byte[] byteArrayObject = null;
        try {
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(vc);
            
            oos.close();
            bos.close();
            
            byteArrayObject = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return byteArrayObject;
        }
        return byteArrayObject;
    }
    
    public static ViewController getJavaObject(byte[] convertObject) {
    	ViewController vc = null;
    	
        ByteArrayInputStream bais;
        ObjectInputStream ins;
        try {
        
        bais = new ByteArrayInputStream(convertObject);
        
        ins = new ObjectInputStream(bais);
         vc =(ViewController) ins.readObject();
        
        ins.close();

        }
        catch (Exception e) {
        e.printStackTrace();
        }
        return vc;
    }
    

    
    
    
    
}
