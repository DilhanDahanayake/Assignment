package com.assignment.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase {


	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\17497\\eclipse-workspace\\Assignment\\src\\main\\java\\com\\assignment\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	public static void initialitation() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\17497\\eclipse-workspace\\Assignment\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
