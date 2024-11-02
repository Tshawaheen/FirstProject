import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayProject {
	
	WebDriver driver = new ChromeDriver();
	String MyWebSite= "https://magento.softwaretestingboard.com";
	String [] FirstNames= {"Tareq","ahmed","shoubash","shawaheen","hashem","auad","zidan"};
	String [] LastNames= {"samara","rihan","shawrmaji","meatMe15","blackmoon"};
	Random rand = new Random();
	int RandomIndexForTheFirstNames = rand.nextInt(FirstNames.length);
	int RandomIndexForTheLastNames = rand.nextInt(LastNames.length);
	

	
	 @BeforeTest
	 public void BeforeMyTest()
	 
	 {
	System.out.println(FirstNames[RandomIndexForTheFirstNames]);
	System.out.println(LastNames[RandomIndexForTheLastNames]);	
	 driver.manage().window().maximize();


		 driver.get(MyWebSite);
 
		 
	 }
	 
	 @Test(priority = 1)
	 public void MyTest() throws InterruptedException {
		 driver.findElement(By.linkText("Create an Account")).click();
		String UserFirstNames= FirstNames[RandomIndexForTheFirstNames];
		 String UserLastNames=LastNames[RandomIndexForTheLastNames];
		 int RandomINTForEmail = rand.nextInt(55555);
		 String DomainEmails ="@gmail.com";
	String passwordin = "T@@areq1234";
		 
		 WebElement FirstNameInput = driver.findElement(By.id("firstname"));
		 FirstNameInput.sendKeys(UserFirstNames);
				 
		 WebElement LastNameinput = driver.findElement(By.id("lastname"));
		 LastNameinput.sendKeys(UserLastNames);
		 
		 WebElement EmailInput = driver.findElement(By.id("email_address"));
		 EmailInput.sendKeys(UserFirstNames+UserLastNames+RandomINTForEmail+DomainEmails);
		 
		 WebElement Passwordinput = driver.findElement(By.id("password"));
		 Passwordinput.sendKeys(passwordin);
		 
		 WebElement PasswordConfinput = driver.findElement(By.id("password-confirmation"));
		 PasswordConfinput.sendKeys(passwordin);
		 
		 
		 Thread.sleep(5000);
		 WebElement CreateAccount = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
		// CreateAccount.click();		 
		  
		 
		 
		 
		  
	 }
	 
	

} 
