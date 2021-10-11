package capital.rise.StepDefs;

import capital.rise.pom.base.BaseTest;
import capital.rise.pom.pages.BuildWealthPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CalculateWealthGoalSteps extends BaseTest{

    private BaseTest baseTest;

    public CalculateWealthGoalSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @Given("Users are in build-wealth page")
    public void users_are_in_build_wealth_page() {
        buildWealthPage = new BuildWealthPage(baseTest.driver).visit();
    }
    @When("Fill out the form")
    public void fill_out_the_form() throws InterruptedException {
        buildWealthPage.calculateWealthGoal("25","350000","20","60","Stability");
    }
    @Then("Verify that Goal Value is computed")
    public void goal_value_is_computed() {
        Assert.assertEquals(buildWealthPage.getWealthGoalValue(), "$1,297,989.52");
    }

}
