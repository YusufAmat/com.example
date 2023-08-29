package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BaseClass;
import pageObjects.LoginPage;
import utils.PropertyReader;

import java.util.Map;

public class LoginSteps extends BaseClass {

    LoginPage loginPage;

    @Given("user on homepage")
    public void userOnHomepage() {
        loginPage = new LoginPage();
        String url = PropertyReader.read("Config").get("url");
        driver.get(url);
    }

    @When("user clicks My Account Link")
    public void userClicksMyAccountLink() {
        click(loginPage.menuMyAccountLink);
    }

    @And("user clicks Login Link")
    public void userClicksLoginLink() {
        click(loginPage.menuLoginLink);
    }

    @Then("Login page should be visible")
    public void loginPageShouldBeVisible() {
        waitForVisibility(loginPage.loginFormUserName);
    }

    @When("user fill the login form with the following data")
    public void userFillTheLoginFormWithTheFollowingData(DataTable table) {
        Map<String, String> map = table.asMap();
        sendKeys(loginPage.loginFormUserName, map.get("username"));
        sendKeys(loginPage.loginFormPassword, map.get("password"));
    }

    @And("user clicks Login button")
    public void userClicksLoginButton() {
        click(loginPage.loginFormSubmitButton);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForVisibility(loginPage.columnRightLogoutLink);
    }

    @And("user clicks on Browser back button")
    public void userClicksOnBrowserBackButton() {
        driver.navigate().back();
    }

    @Then("user should not logged out")
    public void userShouldNotLoggedOut() {
        waitForInvisibility(loginPage.columnRightLoginLink);
    }

    @Then("login should be {string}")
    public void loginShouldBe(String success) {
        if (success.equalsIgnoreCase("true")) {
            waitForVisibility(loginPage.columnRightLogoutLink);
            click(loginPage.columnRightLogoutLink);
        } else {
            waitForVisibility(loginPage.loginFormWarningMessage);
        }
    }
}
