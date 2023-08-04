package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import pages.BankCashPage;
import pages.BrowserFactory;

public class BankCashStepDefination extends BrowserFactory {
	BankCashPage bankcashpage;

	@Then("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String mockData, String fields) {
		bankcashpage = PageFactory.initElements(driver, BankCashPage.class);
		if (fields.equalsIgnoreCase("accountTitle")) {

			bankcashpage.enterTheaccounttitle(mockData + randomgenerato(99));

		} else if (fields.equalsIgnoreCase("description")) {
			bankcashpage.enterTheDescription(mockData);

		} else if (fields.equalsIgnoreCase("initialBalance")) {
			bankcashpage.enterTheBalanceintial(mockData);
		} else if (fields.equalsIgnoreCase("accountNumber")) {
			bankcashpage.enterTheAccountNumber(randomgenerato(999) + mockData);
		} else if (fields.equalsIgnoreCase("contactPerson")) {
			bankcashpage.enterTheContackPersone(mockData + randomgenerato(9999));
		} else if (fields.equalsIgnoreCase("Phone")) {
			bankcashpage.enterThePhoneNumber(mockData + randomgenerato(9999));
		} else if (fields.equalsIgnoreCase("internetBankingURL")) {
			bankcashpage.entertheBankingURL(mockData);
		}
		takeScreenshot(driver);
	}

	@Then("User should be able to validate account created successfully")
	public boolean user_should_be_able_to_validate_account_created_successfully() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expected = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]")).getText();
		System.out.println(expected);
		String actule = "×\r\n" + "Account Created Successfully";
		if (expected.equalsIgnoreCase(actule)) {
			return true;

		}

		takeScreenshot(driver);
		teardown();
		return false;

	}
	

}
