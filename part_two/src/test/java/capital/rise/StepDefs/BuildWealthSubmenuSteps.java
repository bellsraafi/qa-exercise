package capital.rise.StepDefs;

import capital.rise.pom.base.BaseTest;
import capital.rise.pom.factory.DriverManager;
import capital.rise.pom.pages.BuildWealthPage;
import capital.rise.pom.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BuildWealthSubmenuStepDef {
//    protected WebDriver driver;
//    protected HomePage homePage;
//    protected BuildWealthPage buildWealthPage;

    @Before
    public void startDriver(){
//        driver = new DriverManager().initializeDriver();
    }

    @After
    public void quitDriver(){
//        driver.quit();
    }

    @Given("User is on the home page")
    public void visitHomepage(){
//        homePage = new HomePage(driver).visit();
    }

    @When("They click Product menu")
    public void theyClickProductMenu() {
//        homePage.clickProductLink();
    }

    @Then("Verify that Build Wealth submenu is in the submenu list")
    public void verifyThatSubmenuIsInTheSubmenuList() {
//        Assert.assertEquals(homePage.getBuildWealthLinkText(), "Build Wealth");
    }

//    @And("They click Build Menu submenu")
//    public void theyClickSubmenu() {
//        buildWealthPage = homePage.clickBuildWealthLink();
//    }
//
//    @Then("Verify that all Heading One tags are captured an their text are printed")
//    public void verifyThatAllHTagsAreCapturedAnTheirTextArePrinted() {
//        buildWealthPage.getAndPrintAllH1Text();
//    }
}
