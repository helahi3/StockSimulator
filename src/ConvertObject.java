import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConvertObject {

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
