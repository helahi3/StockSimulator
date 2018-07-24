package controller; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import controller.ViewController;

/**
 * FileIO class that deals with exporting portfolio to xml format
 * @author Hamza
 *
 */
public class FileIO {

	/**
	 * Converts a ViewController into XML format
	 * @param view controller
	 * @return xml
	 */
	public static String toXStream(ViewController vc) {
		XStream xs = new XStream();
		String xml = xs.toXML(vc);
		return xml;
	}
	
	/**
	 * Converts an XML string to a View Controller
	 * @param xml
	 * @return view controller
	 */
	public static ViewController toVC(String xml) {
		XStream xs = new XStream();
		ViewController vc = (ViewController) xs.fromXML(xml);
		
		return vc;
	}
	
	/**
	 * Write the string xml to a given file
	 * @param xml
	 * @param filename
	 */
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
	
	/**
	 * Read from a file and return the string xml
	 * @param filename
	 * @return xml 
	 */
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
