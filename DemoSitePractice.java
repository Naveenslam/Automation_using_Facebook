package practices;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSitePractice {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
  //Chromesetup and notficaton disable		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
  //Get Facebook URL,ID, Pass
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("slami1671@gmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("#########");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
  //Use Action class for page down 	
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//span[text()='Photo/video']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		Actions c = new Actions(driver);
		c.sendKeys(Keys.DOWN).build().perform();
		driver.findElement(By.xpath("//span[text()='Only me']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(4000);
		WebElement chooseFile = driver.findElement(By.xpath("//span[text()='Add photos/videos']"));
		chooseFile.click();
		Thread.sleep(4000);
		String file="C:\\Users\\Ravin_P\\Pictures\\Saved Pictures\\naveen_monkeypic.jpg";
		StringSelection selection=new StringSelection(file);
   //toolkit for interaction between keyboard and mouse		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	//robot class using for copy ,paste and enter	
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(4000);
		WebElement clickpic = driver.findElement(By.xpath("//span[text()='Post']"));
		clickpic.click();
		
		
		
		
		
		
		
		
		
	

	}

}
