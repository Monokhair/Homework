package pages;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;




public class BrowserFactory {
	public static WebDriver driver;

	public static void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}

	public static void validation(String expected, String expected2) {
		Assert.assertEquals(expected2, expected);
		

	}

	public static void takeScreenshot(WebDriver driver) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);

		try {
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/screenshot/" + label + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public int randomgenerato(int bound) {
		Random rnd = new Random();
		int randomGenerator = rnd.nextInt(bound);
		return randomGenerator;
		
	}
	public static void teardown() {
		driver.close();
		driver.quit();
		
	}
}
