package capital.rise.pom.pages;

import capital.rise.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BuildWealthPage extends BasePage {

    private By h1Locator = By.tagName("h1");
    private By ageFieldLocator = By.name("age");
    private By salaryFieldLocator = By.name("salary");
    private By investmentPercentageFieldLocator = By.name("investmentPercentage");
    private By retirementAgeFieldLocator = By.name("retirementAge");
    private By investmentPreferenceSelectLocator = By.id("investmentPreference");
    private By btnCalculateLocator = By.cssSelector("button[type='submit']");
    private By wealthGoalValueLocator = By.cssSelector("p[class='text-2xl text-gray2 font-bold']");

    public BuildWealthPage(WebDriver driver) {
        super(driver);
    }

    public BuildWealthPage visit() {
        visit("/build-wealth");
        return this;
    }

    public void getAndPrintAllH1Text() {
        for (WebElement h1 : driver.findElements(h1Locator)) {
            System.out.println(h1.getText());
        }
    }

    public BuildWealthPage enterAge(String age) {
        driver.findElement(ageFieldLocator).clear();
        driver.findElement(ageFieldLocator).sendKeys(age);
        return this;
    }

    public BuildWealthPage enterSalary(String salary) {
        driver.findElement(salaryFieldLocator).clear();
        driver.findElement(salaryFieldLocator).sendKeys(salary);
        return this;
    }

    public BuildWealthPage enterInvestmentPercentage(String investmentPercentage) {
        driver.findElement(investmentPercentageFieldLocator).clear();
        driver.findElement(investmentPercentageFieldLocator).sendKeys(investmentPercentage);
        return this;
    }

    public BuildWealthPage enterRetirementAge(String retirementAge) {
        driver.findElement(retirementAgeFieldLocator).clear();
        driver.findElement(retirementAgeFieldLocator).sendKeys(retirementAge);
        return this;
    }

    public BuildWealthPage selectInvestmentPreference(String investmentPreference) {
        Select investmentPreferenceDropdown = new Select(driver.findElement(investmentPreferenceSelectLocator));
        investmentPreferenceDropdown.selectByVisibleText(investmentPreference);
        return this;
    }

    public BuildWealthPage clickBtnCalculate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(btnCalculateLocator)).click();
//        driver.findElement(btnCalculateLocator).click();
        return this;
    }

    public BuildWealthPage calculateWealthGoal(String age, String salary, String investmentPercentage, String retirementAge, String investmentPreference) throws InterruptedException {
        enterAge(age)
                .enterSalary(salary)
                .enterInvestmentPercentage(investmentPercentage)
                .enterRetirementAge(retirementAge)
                .selectInvestmentPreference(investmentPreference);
        Thread.sleep(500);
        return clickBtnCalculate();
    }

    public String getWealthGoalValue() {
        return driver.findElement(wealthGoalValueLocator).getText();
    }
}