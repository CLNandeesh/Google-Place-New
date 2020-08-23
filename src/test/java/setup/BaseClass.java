package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Utils;

public class BaseClass {

	public static RequestSpecification requestSpecification;
	public static Response response;
	public static PrintStream log;
	public static Properties prop;
	public static FileInputStream fis;
	public static Logger logger;
	//public static RequestSpecification reqSpec;
	public static String place_id;

	static {
		
		

		try {
			fis = new FileInputStream("./src\\test\\java\\resources\\config.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// LOG4J PROPERTY FILE LOAD
				logger = Logger.getLogger(BaseClass.class);
				PropertyConfigurator.configure("./\\src\\test\\java\\resources\\log4j.properties");
				
				
		RestAssured.baseURI = Utils.getPropertyValue("urlProd");
		
		

	}
}
