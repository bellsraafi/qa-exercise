package capital.rise.StepDefs;

import capital.rise.TestNGRunCucumberTest;
import capital.rise.pom.pages.BuildWealthPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CalculateWealthGoalSteps extends TestNGRunCucumberTest {

    @Given("Users are in build-wealth page")
    public void users_are_in_build_wealth_page() {
        buildWealthPage = new BuildWealthPage(driver).visit();
    }
    @When("Fill out the form with {string},{string},{string},{string},{string}")
    public void fillOutTheFormWith(String age, String salary, String investmentPercentage, String retirmentAge, String investmentPreference) throws InterruptedException {
        buildWealthPage.calculateWealthGoal(age,salary,investmentPercentage,retirmentAge,investmentPreference);
    }
    @Then("Verify that Goal Value is computed to {string}")
    public void goal_value_is_computed(String goalValue) {
        Assert.assertEquals(buildWealthPage.getWealthGoalValue(), goalValue);
    }


}
