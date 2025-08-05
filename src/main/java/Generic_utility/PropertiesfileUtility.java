package Generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesfileUtility {
	
	public String togetdataFromPropertiesfile(String Key) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value= prop.getProperty(Key);
		return value;
	}
	
	

}
