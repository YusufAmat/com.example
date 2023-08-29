package stepdefs;

import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Utilities;

public class Hooks {

    @AfterStep
    public void afterStep(Scenario scenario){
        if (scenario.isFailed()){
            Utilities.takeScreenShot();
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After(order = 1)
    public void after(Scenario scenario){
        if (scenario.isFailed()){
            Utilities.takeScreenShot();
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After(order = 0)
    public void after() {
        Driver.quitDriver();
    }
}
