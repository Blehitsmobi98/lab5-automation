package Lab5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class uploadFile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users//4066//Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://omayo.blogspot.in/");
		Thread.sleep(2000);
		
		//uploading file
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='uploadfile' and @name='anyfile']"));
		Actions act = new Actions(driver);
		act.scrollToElement(fileUpload).perform();
		fileUpload.sendKeys("C://Users//4066//Desktop//Hira Naz Assignments//VS.pdf");

	}

}
