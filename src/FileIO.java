import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import controller.ViewController;

public class FileIO {

	public String toXStream(ViewController vc) {
		XStream xs = new XStream();
		String xml = xs.toXML(vc);
		return xml;
	}
	
	public ViewController toVC(String xml) {
		XStream xs = new XStream();
		ViewController vc = (ViewController) xs.fromXML(xml);
		
		return vc;
	}
	
	public static void writeToFile(String xml, String filename) {
		
		try {
			FileWriter fr = new FileWriter(filename);
			BufferedWriter br = new BufferedWriter(fr);
			
			br.write(xml);
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find the file: " + filename);
		} catch (IOException e) {
			throw new IllegalArgumentException("IO Exception with this file: " + filename);
		}
		
	}
	
	public static String readFromFile(String filename) {
		String xml = "";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			xml = br.readLine();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find the file: " + filename);
		} catch (IOException e) {
			throw new IllegalArgumentException("IO Exception with this file: " + filename);
		}
		
		return "";
	}
	
	
	
    
    
}
