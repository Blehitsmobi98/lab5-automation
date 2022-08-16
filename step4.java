package Lab5;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class step4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users//4066//Documents/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://omayo.blogspot.in/");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		
		//selecting from multi drop-down
		//WebElement multiSelect = driver.findElement(By.id("multiselect1"));
		WebElement multiSelect = driver.findElement(By.xpath("//h2[text()='Multi Selection box']//following-sibling::div//select[starts-with(@id,'multiselect')]"));
		act.scrollToElement(multiSelect).perform();
		Select cars = new Select(multiSelect);
		cars.selectByValue("Hyundaix");
		//selecting directly
		driver.findElement(By.xpath("//select[@id='multiselect1']//child::option[@value='audix']")).click();
		
		//selecting from single drop-down
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='combobox' and @name='SiteMap']"));
		Select docs = new Select(dropdown);
		docs.selectByVisibleText("doc 3");
		
		//enter hello in text box
		WebElement txtbox = driver.findElement(By.xpath("//input[@name='fname' and @value='Selenium WebDriver']"));
		txtbox.clear();
		txtbox.sendKeys("Hello");
		Thread.sleep(2000);
		
		// clicking on enabled button
		driver.findElement(By.xpath("//button[@type='button' and contains(@id,'but') and text()='Button2']")).click();
		Thread.sleep(4000);
		
		//clicking on three buttons
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
		//handle alert
		WebElement alertBtn = driver.findElement(By.xpath("//input[contains(@id,'alert') and @value='ClickAfterTextDissappears']"));
		act.scrollToElement(alertBtn).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("deletesuccess")));
		alertBtn.click();
		
		if(wait.until(ExpectedConditions.alertIsPresent())!= null) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
		}
		Thread.sleep(2000);
		
		//pop-up window
		String parentWindow = driver.getWindowHandle();
		WebElement popup = driver.findElement(By.xpath("//a[contains(text(),'Open a popup window')]"));
		act.scrollToElement(popup).perform();
		popup.click();
		Set<String> handles = driver.getWindowHandles();
		for (String han:handles) {
		    System.out.println(han);
			if(!han.equals(parentWindow)) {
				driver.switchTo().window(han);
				WebElement txt = driver.findElement(By.xpath("//body"));
				System.out.println(txt.getText());
				Thread.sleep(3000);
			    driver.close();
				}		
			}
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		//click on try it button
		//driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//other xpath
		driver.findElement(By.xpath("//button[@id='myBtn']//following-sibling::button")).click();
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myBtn")));
		
		//double click
		WebElement doClick = driver.findElement(By.xpath("//button[text()=' Double click Here   ']"));
		act.scrollToElement(popup).doubleClick(doClick).build().perform();
		if(wait.until(ExpectedConditions.alertIsPresent())!= null) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
		}
		Thread.sleep(2000);
		
		//click and wait checkbox
		driver.findElement(By.xpath("//button[text()='Check this']")).click();
		WebElement chkbx = driver.findElement(By.xpath("//input[@id='dte' and @value='Pen']"));
		wait.until(ExpectedConditions.elementToBeClickable(chkbx)).click();
		
		
		
		System.out.println("Done");


	}

}
