package capital.rise.StepDefs;

import capital.rise.pom.base.BaseTest;
import capital.rise.pom.factory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseTest {

    private BaseTest baseTest;

    public Hook(BaseTest baseTest){
        this.baseTest = baseTest;
    }
    @Before
    public void startDriver(){
        baseTest.driver = new DriverManager().initializeDriver();
    }

    @After
    public void quitDriver(){
        baseTest.driver.quit();
    }
}
