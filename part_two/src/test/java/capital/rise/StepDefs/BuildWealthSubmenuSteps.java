package capital.rise.StepDefs;


import capital.rise.TestNGRunCucumberTest;
import capital.rise.pom.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BuildWealthSubmenuSteps extends TestNGRunCucumberTest {
    @Given("User is on the home page")
    public void visitHomepage(){
        homePage = new HomePage(driver).visit();
    }
    @When("They click Product menu")
    public void theyClickProductMenu() {
        homePage.clickProductLink();
    }
    @Then("Verify that Build Wealth submenu is in the submenu list")
    public void verifyThatSubmenuIsInTheSubmenuList() {
        Assert.assertEquals(homePage.getBuildWealthLinkText(), "Build Wealth");
    }
    @And("They click Build Menu submenu")
    public void theyClickSubmenu() {
        buildWealthPage = homePage.clickBuildWealthLink();
    }
    @Then("Verify that all Heading One tags are captured an their text are printed")
    public void verifyThatAllHTagsAreCapturedAnTheirTextArePrinted() {
        buildWealthPage.getAndPrintAllH1Text();
    }
}
