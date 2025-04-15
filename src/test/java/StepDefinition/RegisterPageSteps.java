package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPageSteps {
	static  WebDriver driver;
	

@Given("user is on register page")
public void user_is_on_register_page() 
{
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\91937\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    driver.manage().deleteAllCookies();
    driver.get("https://demo.guru99.com/test/newtours/register.php");

}

@When("user enter firstname lastname phone and email")
public void user_enter_firstname_lastname_phone_and_email()
{
	driver.findElement(By.name("firstName")).sendKeys("Nikhil");
	driver.findElement(By.name("lastName")).sendKeys("Khalate");
	driver.findElement(By.name("phone")).sendKeys("637638");
	driver.findElement(By.name("userName")).sendKeys("nsk@gmail.com");
    
}

@When("user enter address city state postal code and country")
public void user_enter_address_city_state_postal_code_and_country() 
{
	driver.findElement(By.name("address1")).sendKeys("Pune");
	driver.findElement(By.name("city")).sendKeys("Pune");
	driver.findElement(By.name("state")).sendKeys("MH");
	driver.findElement(By.name("postalCode")).sendKeys("354363");
	WebElement wb1=driver.findElement(By.name("country"));
	Select sel= new Select(wb1);
	sel.selectByVisibleText("INDIA");

}

@When("user enter username password confirm password and click on submit button")
public void user_enter_username_password_confirm_password_and_click_on_submit_button() throws InterruptedException
{
	driver.findElement(By.name("email")).sendKeys("nsknikhil");
	driver.findElement(By.name("password")).sendKeys("nsk@123");
	driver.findElement(By.name("confirmPassword")).sendKeys("nsk@123");
	driver.findElement(By.name("submit")).click();
   Thread.sleep(3000);
}

@Then("user is on success page and validate success page url")
public void user_is_on_success_page_and_validate_success_page_url()
{
	String actualurl=driver.getCurrentUrl();
	boolean a=actualurl.contains("sucess");
	Assert.assertEquals(a, true);
   
}

@When("user click on sign in link")
public void user_click_on_sign_in_link() 
{
	driver.findElement(By.xpath("//a[text()=' sign-in ']")).click();
  
}

@When("user enter valid username, password and click on submit button")
public void user_enter_valid_username_password_and_click_on_submit_button() 
{
	driver.findElement(By.name("userName")).sendKeys("nsknikhil");
	driver.findElement(By.name("password")).sendKeys("nsk@123");
	driver.findElement(By.name("submit")).click();
   
}

@Then("user is on login successful page and validate url")
public void user_is_on_login_successful_page_and_validate_url()
{
	String actualurl=driver.getCurrentUrl();
	boolean b=actualurl.contains("login_sucess");
	Assert.assertTrue(b);
   
}

@Then("user validate Successfully keyword in login success page")
public void user_validate_successfully_keyword_in_login_success_page() 
{
  String d= driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();
  Assert.assertEquals(d, "Login Successfully");
  System.out.println("TC 1 created by NSK Tester");
  System.out.println("TC 2 created by Sonali Tester");
  System.out.println("TC 3 created by NSK Tester");
  System.out.println("TC 4 created by Sonali Tester");
  
}


}
