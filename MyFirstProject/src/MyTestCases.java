import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	
	WebDriver driver = new ChromeDriver();
	
			
	
@BeforeTest 
public void setup () {
	driver.manage().window().maximize(); 
	driver.get("https://www.google.com");
	
}

@Test
public void serachAboutMyself () {
	
	driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("facebook"+Keys.ENTER);
	//driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
}


@AfterTest
public void afterMyTest () {
*	driver.close();*/
	}

	

}
