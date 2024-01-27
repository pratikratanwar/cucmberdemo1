package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.print.DocFlavor.URL;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	static Logger Logger;
	
public static WebDriver initilizeBrowser() throws IOException
{
	
if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
      {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	//os
	if(getProperties().getProperty("os").equalsIgnoreCase("windows"))
	{
		capabilities.setPlatform(Platform.WIN11);
	}else if (getProperties().getProperty("os").equalsIgnoreCase("mac"))
	{
		capabilities.setPlatform(Platform.MAC);
	}else
	{
		System.out.println("No matching os..");
	}
	
	//browser
	switch (getProperties().getProperty("browser").toLowerCase())
	{
	case "chrome":
		capabilities.setBrowserName("chrome");
		break;
	case "edge":
		capabilities.setBrowserName("MicrosoftEdge");
	    break;
	default:
		System.out.println("No matching browser");
	
	}
	
driver = new RemoteWebDriver(new URL("https://demo.nopcommerce.com/"),capabilities);	
	
	
	
      }

else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))

{
	
switch (getProperties().getProperty("browser").toLowerCase())
{
case "chrome":
	driver= new ChromeDriver();
	break;
case "edge"	:
	driver = new EdgeDriver();
	break;
default:
	System.out.println("No matching browser");
driver=null;


}


}

driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
return driver;


}


public static WebDriver getDriver() {
	
	return driver;
}


public static Properties getProperties() throws IOException
{
	FileReader file=FileReader(System.getProperty("user.dir")+"\\src\\test\\resource\\config.properties");
p= new Properties();
p.load(file);

return p;



}

public static Logger getLogger() {
	
	logger=LogManager.getLogger();
	return logger;
}


public static String randomeString() {
	
	String generatedString= RandomStringUtils.randomAlphabetic(5);
	return generatedString;
	
}

public static String randomNumber() {
	
	String generatedString=RandomStringUtils.randomNumeric(10);
	return generatedString;
}


public static String randomAplhaNumeric() {
	
	String str=RandomStringUtils.randomAlphabetic(5);
	String num= RandomStringUtils.randomNumeric(10);
	return str+num;
}





	
	
	
	
	
	
	
	
	
	

}
