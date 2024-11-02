import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TareqTestProject {

	WebDriver driver = new ChromeDriver();
	String TheWebSite1 = "https://magento.softwaretestingboard.com/customer/account/create/";

	@BeforeTest
	public void BeforeMyTest() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get(TheWebSite1);
//		driver.navigate().back();
//		driver.navigate().forward();
//		System.out.println(driver.getCurrentUrl().toUpperCase());
//		System.out.println(driver.getWindowHandle());
//		System.out.println(driver.getTitle());
//		Thread.sleep(5000);
//		driver.navigate().refresh();
//		

	}

	@Test(priority = 1)
	public void signUp() {

		driver.findElement(By.partialLinkText("Create an Account")).click();
		WebElement FirstNameInput = driver.findElement(By.id("firstname"));
		FirstNameInput.sendKeys("Tatrq");
		WebElement LastNameInput = driver.findElement(By.id("lastname"));
		LastNameInput.sendKeys("shawaheen");
		WebElement EmailInput = driver.findElement(By.id("email_address"));
		EmailInput.sendKeys("tareqsh@gmail.com");
		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys("Tareqss@123");
		WebElement ConfirmPassInput = driver.findElement(By.id("password-confirmation"));
		ConfirmPassInput.sendKeys("Tareqss@123");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();

	}

}
