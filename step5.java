package Lab5;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class step5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users//4066//Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://omayo.blogspot.in/");
		Thread.sleep(2000);
		
		//selecting gender
		driver.findElement(By.xpath("//input[@name='gender' and @value='female']")).click();
		System.out.println("Gender selected");
		
		//handle alert
		driver.findElement(By.xpath("//input[@value='ClickToGetAlert' and contains(@id,'alert')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if(wait.until(ExpectedConditions.alertIsPresent())!= null) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
		}
		Thread.sleep(2000);
		System.out.println("Alert handeled");
		
		//select blue, de-select orange
		WebElement orange = driver.findElement(By.xpath("//input[@type='checkbox' and @value='orange']"));
		if(orange.isSelected()==true) {
			orange.click();
		}
		System.out.println("Orange deselected");
		//select blue
		WebElement blue = driver.findElement(By.xpath("//input[@type='checkbox' and @value='blue']"));
		if(blue.isSelected()== false) {
			blue.click();
		}
		System.out.println("Blue selected");
		
		//read text
		WebElement text = driver.findElement(By.xpath("//input[@id='rotb' and @type='text']"));
		System.out.println(text.getText());
		
		//prompt and confirmation
		//prompt alert
		driver.findElement(By.xpath("//input[@id='prompt' and @value='GetPrompt']")).click();
		if(wait.until(ExpectedConditions.alertIsPresent())!= null) {
			Alert palert = driver.switchTo().alert();
			palert.sendKeys("Hira");
			Thread.sleep(2000);
			palert.accept();
		}
		Thread.sleep(2000);
		//confirmation alert
		driver.findElement(By.xpath("//input[@id='confirm' and @value='GetConfirmation']")).click();
		if(wait.until(ExpectedConditions.alertIsPresent())!= null) {
			Alert calert = driver.switchTo().alert();
			System.out.println(calert.getText());
			Thread.sleep(2000);
			calert.dismiss();
		}
		Thread.sleep(2000);
		
		//enter text
		//box1
		driver.findElement(By.xpath("//h2[text()='Locate using class']//following-sibling::div//input[@class='classone']")).sendKeys("Hello");
		//box2
		//driver.findElement(By.xpath("//div[@id='HTML28']//div//input[@class='classone']")).sendKeys("How are u");
		driver.findElement(By.xpath("//h2[text()='element having same class name of above field']//following-sibling::div//input[@type='text' and @class='classone']")).sendKeys("How are u");
		
		//select car
		driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']")).click();
		
		//select bag and book and then de-select book
		//selecting bag
		WebElement bag = driver.findElement(By.xpath("//input[@name='accessories' and @value='Bag']"));
		if(bag.isSelected()== false) {
			bag.click();
		}
		//de-selecting book
		WebElement book = driver.findElement(By.xpath("//input[@name='accessories' and @value='Book']"));
		if(book.isSelected()== true) {
			book.click();
		}
		
		//delayed drop=down handle
		driver.findElement(By.xpath("//button[@class='dropbtn' and text()='Dropdown']")).click();
		WebElement gmail = driver.findElement(By.xpath("//a[text()='Gmail' and contains(@href,'gmail')]"));
		wait.until(ExpectedConditions.elementToBeClickable(gmail)).click();
		
		System.out.println("Done");
		

	}

}
