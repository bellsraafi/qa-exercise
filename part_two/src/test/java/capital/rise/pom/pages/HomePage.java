package capital.rise.pom.pages;

import capital.rise.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By productLinkLocator = By.cssSelector("span[class='flex-center'] span");
    private By buildWealthSubmenuLocator = By.cssSelector("nav[class='mdMax:hidden flex items-center space-x-10'] div a:nth-child(4)");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage visit(){
        visit("/");
        return this;
    }

    public HomePage clickProductLink(){
        driver.findElement(productLinkLocator).click();
        return this;
    }

    public  String getBuildWealthLinkText(){
        return driver.findElement(buildWealthSubmenuLocator).getText();
    }
    public  BuildWealthPage clickBuildWealthLink(){
        driver.findElement(buildWealthSubmenuLocator).click();
        return new BuildWealthPage(driver);
    }

    public BuildWealthPage visitBuildWealthPage(){
        return clickProductLink()
                .visitBuildWealthPage();
    }
}
