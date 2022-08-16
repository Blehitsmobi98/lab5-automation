package Lab5;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class step3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users//4066//Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://omayo.blogspot.in/");
		// defining actions to perform
		Actions act =  new Actions(driver);
		
		driver.switchTo().defaultContent();
		
		//switching to frame1
		//WebElement frm1 = driver.findElement(By.xpath("//div[@id='HTML21' and @class='widget HTML']//iframe[@id='iframe1']"));
		WebElement frm1 = driver.findElement(By.xpath("//h2[text()='Iframe1 & Iframe2']//following-sibling::div//iframe[@id='iframe1']"));
		driver.switchTo().frame(frm1);
		act.moveByOffset(5, 6).perform();
		//act.moveToElement(frm1).perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		//switching to frame2
		WebElement frm2 = driver.findElement(By.xpath("//h2[text()='Iframe1 & Iframe2']//following-sibling::div//iframe[@id='iframe2' and contains(@src,'theautomatedtester')]"));
		driver.switchTo().frame(frm2);
		act.moveByOffset(5, 6).perform();
		//act.moveToElement(frm2).perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		//enter user name and password and handling alert
		WebElement uname = driver.findElement(By.xpath("//form[@name='login']//child::input[@type='text' and @name='userid']"));
		act.moveToElement(uname);
		Thread.sleep(3000);
		uname.sendKeys("Maha");
		driver.findElement(By.xpath("//form[@name='login']//child::input[@type='password' and @name='pswrd']")).sendKeys("ab12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@name='login']//child::input[@type='button' and @value='Login']")).click();
		//adding explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(wait.until(ExpectedConditions.alertIsPresent())!= null) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
		}
		Thread.sleep(2000);
		
		//clicking on cancel to clear all
		driver.findElement(By.xpath("//form[@name='login']//child::input[@type='reset' and @value='Cancel']")).click();
		System.out.println("Done");

	}

}
