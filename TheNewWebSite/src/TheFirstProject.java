import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.opentelemetry.sdk.metrics.InstrumentSelectorBuilder;

public class TheFirstProject {

	WebDriver driver = new ChromeDriver();
	String MyWebsite = "https://automationteststore.com/";

	String[] FirstNames = { "Tareq", "ahmed", "shoubash", "shawaheen", "hashem", "auad", "zidan" };
	String[] LastNames = { "samara", "rihan", "shawrmaji", "meatMe15", "blackmoon" };
	String globalUserName = "";
	String globalUserNameForLogIn;
	String globalPassword = "";
	Random rand = new Random();
	int RandomIndexForTheFirstNames = rand.nextInt(FirstNames.length);
	int RandomIndexForTheLastNames = rand.nextInt(LastNames.length);

	@BeforeTest

	public void BeforeMyTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(MyWebsite);

	}

	@Test(priority = 1)

	public void SignUpTest() throws InterruptedException {

		driver.findElement(By.linkText("Login or register")).click();
		WebElement SignUpButton = driver.findElement(By.xpath("//Button[@title='Continue']"));
		SignUpButton.click();
		Thread.sleep(3000);

		String UserFirstNames = FirstNames[RandomIndexForTheFirstNames];
		String UserLastNames = LastNames[RandomIndexForTheLastNames];
		int RandomINTForEmail = rand.nextInt(55555);
		String DomainEmails = "@gmail.com";
		String passwordin = "T@@areq1234";

		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		FirstNameInput.sendKeys(UserFirstNames);
		globalUserName = UserFirstNames;

		WebElement LastNameinput = driver.findElement(By.id("AccountFrm_lastname"));
		LastNameinput.sendKeys(UserLastNames);

		WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
		emailInput.sendKeys(UserFirstNames + UserLastNames + RandomINTForEmail + DomainEmails);

		WebElement addressInput = driver.findElement(By.id("AccountFrm_address_1"));
		addressInput.sendKeys("Amman-Swafeh");

		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));
		cityInput.sendKeys("The Capital City");

		WebElement countryInput = driver.findElement(By.id("AccountFrm_country_id"));
		Select selector1 = new Select(countryInput);
		int randomCountry = rand.nextInt(1, 140);
		selector1.selectByIndex(randomCountry);

		Thread.sleep(3000);

		WebElement regionInput = driver.findElement(By.id("AccountFrm_zone_id"));// Region
		Select selector2 = new Select(regionInput);
		int randomRegion = rand.nextInt(1, 5);
		selector2.selectByIndex(randomRegion);

		WebElement zipCodeInput = driver.findElement(By.id("AccountFrm_postcode"));// ZIP Code
		zipCodeInput.sendKeys("13310");

		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));// LoginName
		String localUserName = UserFirstNames + UserLastNames + RandomINTForEmail;
		globalUserNameForLogIn = localUserName;
		loginNameInput.sendKeys(localUserName);

		WebElement Passwordinput = driver.findElement(By.id("AccountFrm_password"));
		Passwordinput.sendKeys(passwordin);
		globalPassword = passwordin;

		WebElement PasswordConfinput = driver.findElement(By.id("AccountFrm_confirm"));
		PasswordConfinput.sendKeys(passwordin);

		WebElement agreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));
		agreeCheckBox.click();
		WebElement ContinueButton = driver.findElement(By.xpath("//Button[@title='Continue']"));
		ContinueButton.click();

	}

	@Test(priority = 2)
	public void LogOutTest() throws InterruptedException {
		Thread.sleep(4000);
		WebElement userNav = driver.findElement(By.id("customernav"));
		Actions action = new Actions(driver);
		action.moveToElement(userNav).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Not " + globalUserName + "? Logoff")).click();
		;

	}

	@Test(priority = 3)
	public void LoginTest() throws InterruptedException {

		driver.findElement(By.linkText("Login or register")).click();
		WebElement logInInput = driver.findElement(By.id("loginFrm_loginname"));
		logInInput.sendKeys(globalUserNameForLogIn);

		WebElement PasswordLogIn = driver.findElement(By.id("loginFrm_password"));
		PasswordLogIn.sendKeys(globalPassword);
		WebElement logInButton = driver.findElement(By.xpath("//Button[@title='Login']"));
		Thread.sleep(2000);

		logInButton.click();

	}

	@Test(priority = 4)
	public void AddItemToTheCart() throws InterruptedException {

		String[] webSiteForTheItems = { "https://automationteststore.com/index.php?rt=product/category&path=68",
				"https://automationteststore.com/index.php?rt=product/category&path=36",
				"https://automationteststore.com/index.php?rt=product/category&path=43",
				"https://automationteststore.com/index.php?rt=product/category&path=49",
				"https://automationteststore.com/index.php?rt=product/category&path=58",
				"https://automationteststore.com/index.php?rt=product/category&path=52",
				"https://automationteststore.com/index.php?rt=product/category&path=65" };

		int randomIndex = rand.nextInt(webSiteForTheItems.length);
		driver.get(webSiteForTheItems[randomIndex]);

		// define for the webelement which is a UL tag
		WebElement listOfItems = driver.findElement(By.cssSelector(".thumbnails.row"));
		// each UL tag has always a li items (list items ) here i am getting the total
		// number of li inside the ul
		int totalNumberOfItems = listOfItems.findElements(By.tagName("li")).size();
		// create a random index based on the total number of items that i got in the
		// previous line
		int randomIndexOfTheItem = rand.nextInt(totalNumberOfItems);
		// sleep just to see the results before click on the sub category
		Thread.sleep(3000);
		// inside the sub category i need selenium to click on a random sub category
		listOfItems.findElements(By.tagName("li")).get(randomIndexOfTheItem).click();

		// i defined the container of all items in a Container variable to loop over all
		// items inside using the css selector
		WebElement container = driver.findElement(By.cssSelector(".thumbnails.grid.row.list-inline"));
		// we need to see how many items that selenium found inside the container
		int numbersOfProducts = container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).size();
		// random index for the item to randomly select one item each time
		int randomIndexForTheProducts = rand.nextInt(numbersOfProducts);

		Thread.sleep(1000);
		// the randomly item that we generated using rand.nextInt we need to click on
		// that item
		container.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12")).get(randomIndexForTheProducts).click();
		Thread.sleep(5000);
		// here i have an UL tag which contains either the Add to cart or out of the
		// stock
		WebElement ulList = driver.findElement(By.className("productpagecart"));
		// inside the UL that i found in the previous line of code i am searching about
		// the a tag noting:-
		// (a) tag if the item in the stock and span tag if the item out of the stock
		int liItem = ulList.findElements(By.tagName("li")).get(0).findElements(By.tagName("span")).size();
		// this liItem will give me either 0 or 1 ( 0 if the item out of the stock so it
		// will go back to the home page and print a message says that the item out of
		// the stock , if it gives 1 that means the item inside the stock and i can
		// press on the add to cart button by using it's name which is cart
		if (liItem > 0) {
			driver.get(MyWebsite);
			System.out.println("sorry the item out of the stock");
			String expectedResult = "https://automationteststore.com/";
			String actualResult = driver.getCurrentUrl();
			org.testng.Assert.assertEquals(actualResult, expectedResult);

		} else {

			driver.findElement(By.className("cart")).click();
			Thread.sleep(2000);
			String actualResult = driver.findElement(By.className("heading1")).getText();
			String expectedResult = "Shopping Cart";

			org.testng.Assert.assertEquals(actualResult, expectedResult.toUpperCase());

		}

	}

}
