package Lab5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class step2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C://Users//4066//Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://omayo.blogspot.in/");
		Actions act= new Actions(driver);
		
		// to print all table entries at once
		WebElement table = driver.findElement(By.xpath("//h2[text()='Table']//following-sibling::div//table"));
		act.moveToElement(table).perform();
		//System.out.println(table.getText());
		
		//storing and printing header of table
		
		//List<WebElement> header = driver.findElements(By.xpath("//table[@id='table1']//th"));
	
		
		List<WebElement> header = driver.findElements(By.xpath("//h2[text()='Table']//following-sibling::div//table//th"));
		
		List<String> listHeader = new ArrayList<>();
		for(WebElement head:header) {
			listHeader.add(head.getText());
		}
		System.out.println(listHeader);
		System.out.println(listHeader.get(0));
		
		//storing and printing all info of each column separately
		
		//names
		//List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[1]"));
		List<WebElement> names = driver.findElements(By.xpath("//h2[text()='Table']//following-sibling::div//table//tbody//tr//td[1]"));
		List<String> listCol1 = new ArrayList<>();
		for(WebElement col1:names) {
			listCol1.add(col1.getText());
		}
		System.out.println(listCol1);
		
		//age
		List<WebElement> age = driver.findElements(By.xpath("//h2[text()='Table']//following-sibling::div//table//tbody//tr//td[2]"));
		List<String> listCol2 = new ArrayList<>();
		for(WebElement col2:age) {
			listCol2.add(col2.getText());
		}
		System.out.println(listCol2);		
		
		//place
		List<WebElement> place = driver.findElements(By.xpath("//h2[text()='Table']//following-sibling::div//table//tbody//tr//td[3]"));
		List<String> listCol3 = new ArrayList<>();
		for(WebElement col3:place) {
			listCol3.add(col3.getText());
		}
		System.out.println(listCol3);	
		
		//to get all info of person2 (Manish)
		System.out.println(listCol1.get(1));
		System.out.println(listCol2.get(1));
		System.out.println(listCol3.get(1));
		
		//enter name password and login
		//driver.findElement(By.xpath("//form[@name='form1']//child::input[@type='text']")).sendKeys("Maha");
		driver.findElement(By.xpath("//h2[text()='HTML Form']//following-sibling::div//form//input[@type='text']")).sendKeys("Maha");
		driver.findElement(By.xpath("//h2[text()='HTML Form']//following-sibling::div//form//input[@type='password']")).sendKeys("aabb1122");
		driver.findElement(By.xpath("//button[@value='LogIn']")).click();
		//driver.close();
		System.out.println("Done");
	
		
	}

}
