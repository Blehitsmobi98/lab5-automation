package Lab5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class step1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users//4066//Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://omayo.blogspot.in/");
		
		//enter text
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement txtarea = wait.until(ExpectedConditions.elementToBeClickable(By.id("ta1")));
		WebElement txtarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='Text Area Field']//following-sibling::div//textarea")));
		txtarea.sendKeys("Hira Naz");
		
		//read delete and then enter text
		
		//WebElement txtarea2 = driver.findElement(By.xpath("//div[@class='widget HTML' and @id='HTML11']//child::div//child::textarea"));
		WebElement txtarea2 = driver.findElement(By.xpath("//h2[text()='Text Area Field Two']//following-sibling::div//textarea"));
		String text = txtarea2.getText();
		System.out.println("Text in text-field is: ");
		System.out.println(text);
		Thread.sleep(3000);
		txtarea2.clear();
		txtarea2.sendKeys("I don't know");
		
		System.out.println("Done");
		
		
		

	}

}
