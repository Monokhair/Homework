package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BankCashPage;
import pages.BrowserFactory;
import pages.LoginPage;

public class loginStepsDefination extends BrowserFactory {

	LoginPage loginPage;
	BankCashPage bankcashpage;

	@Before
	public void beforetest() {
		init();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		bankcashpage = PageFactory.initElements(driver, BankCashPage.class);

	}

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {

		driver.get("https://techfios.com/billing/?ng=dashboard/");
	}

	@When("User enters the {string} in the {string} field")
	public void user_enters_the_in_the_field(String loginmock, String field) {

		if (field.equalsIgnoreCase("password")) {
			loginPage.enter_the_password(loginmock);

		} else if (field.equalsIgnoreCase("username")) {
			loginPage.enter_the_user_name(loginmock);
		}takeScreenshot(driver);

	}

	@Then("User clicks on {string}")
	public void user_clicks_on(String button) {
		if (button.equalsIgnoreCase("login")) {
			loginPage.click_signin_button();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button.equalsIgnoreCase("bankCash")) {
			bankcashpage.click_BankCash();
		} else if (button.equalsIgnoreCase("newAccount")) {
			bankcashpage.click_newaccount();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String expected = driver.getTitle();
			String actule = "Accounts- iBilling";
			validation(expected, actule);
			takeScreenshot(driver);
		}else if (button.equalsIgnoreCase("submit")) {
			bankcashpage.click_submit();
			
		}

	}

	@Then("User should land on Dashboard page")
	public void user_should_land_on_Dashboard_page() {
		String expected = driver.getTitle();
		String actule = "Dashboard- iBilling";
		validation(expected, actule);
		takeScreenshot(driver);
	}


}
