package capital.rise.pom.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String endPoint){
        driver.get("https://rise.capital" + endPoint);
    }
}

