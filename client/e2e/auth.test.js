require('chromedriver');
const config = require('config');
const { Builder, By, until, Key } = require('selenium-webdriver');
const assert = require('assert');
  
const baseUrl = config.get('baseURL');
const USERNAME = config.get('username');
const PASSWORD = config.get('password');
const FIRSTNAME = config.get('firstname');
const LASTNAME = config.get('lastname');
const EXPLICIT_WAIT_MS = config.get('explicitWaitMS');

////////////////// LOCATORS //////////////////////
const singinWithGoogleLink = By.css('img[alt="Sign in with Google"]');
const inputEmailLocator = By.css('input[type="email"]');
const inputPasswordLocator = By.css('input[type="password"]');
const btnNextLocator = By.css('div[id="identifierNext"]');
const btnAcceptLocator = By.xpath('//button[contains(text(),"Accept")]');
const profileImageLocator = By.css('img.Avatar');
const firstNameLocator = By.xpath('//body[1]/div[1]/div[1]/div[3]/strong[1]');
const lastNameLocator = By.xpath('//body[1]/div[1]/div[1]/div[4]/strong[1]');
/////////////////////////////////////////////////

describe('End to End Test Suite', function () {
  before(async function () {
    driver = await new Builder().forBrowser('chrome').build();
  });

  it('should get authenticated with Google account', async function () {
    await driver.get(baseUrl);
    await driver.findElement(singinWithGoogleLink).click();
    await driver.findElement(inputEmailLocator).sendKeys(USERNAME);
    await driver.findElement(btnNextLocator).click();
    await driver.wait(
      until.stalenessOf(driver.findElement(inputPasswordLocator)),
      EXPLICIT_WAIT_MS
    );
    await driver.findElement(inputPasswordLocator).sendKeys(PASSWORD);
    await driver.findElement(inputPasswordLocator).sendKeys(Key.ENTER);
    try {
      await driver.wait(until.elementLocated(btnAcceptLocator), EXPLICIT_WAIT_MS).click()
    } catch (error) {}
    const profileImageEle = await driver.wait(until.elementLocated(profileImageLocator), EXPLICIT_WAIT_MS);
    const fNameEle = await driver.wait(until.elementLocated(firstNameLocator), EXPLICIT_WAIT_MS);
    const lNameEle = await driver.wait(until.elementLocated(lastNameLocator), EXPLICIT_WAIT_MS);

    const fName = await fNameEle.getText();
    const lName = await lNameEle.getText();
    const profileImageSrc = await profileImageEle.getAttribute('src');
    const profileImageIsDisplayed = await profileImageEle.isDisplayed();

    assert.equal(fName, FIRSTNAME);
    assert.equal(lName, LASTNAME);
    assert.equal(profileImageSrc !== null && profileImageIsDisplayed, true);
  });
  after(async function () {
    await driver.quit();
  });
});
