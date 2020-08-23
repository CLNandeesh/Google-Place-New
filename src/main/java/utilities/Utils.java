package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import setup.BaseClass;

public class Utils extends BaseClass{

	public static String staticJsonReader(String path) throws IOException {

		// jsonBodyAsString variable stores complete body as string
		String jsonBodyAsString = new String(Files.readAllBytes(Paths.get(path)));

		return jsonBodyAsString;
	}
	
	
	public static String getPropertyValue(String key)
	{
		String value =prop.getProperty(key);
		return value;
		
	}

}
