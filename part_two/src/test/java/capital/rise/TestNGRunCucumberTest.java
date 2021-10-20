package capital.rise;

import capital.rise.pom.factory.DriverManager;
import capital.rise.pom.pages.BuildWealthPage;
import capital.rise.pom.pages.HomePage;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "capital.rise.StepDefs" }, plugin = { "pretty",
        "json:target/cucumber/cucumber.json" })

public class TestNGRunCucumberTest {
    protected static WebDriver driver = null;
    private TestNGCucumberRunner testNGCucumberRunner;

    protected HomePage homePage;
    protected BuildWealthPage buildWealthPage;

    @BeforeClass
    @Parameters(value = { "browser", "version" })
    public void beforeClass() {
        driver = new DriverManager().initializeDriver();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        testNGCucumberRunner.finish();
    }
}
