package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.Browser;
import com.epam.tat.steam.form.page.GamePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractElement implements Element {

    protected WebElement webElement;
    private By locator;
    private final Logger logger = LogManager.getLogger();
    private static final int WAIT_TIME_SECONDS = 10;

    protected AbstractElement(By locator) {
        this.locator = locator;
    }

    protected AbstractElement(final WebElement webElement) {
        this.webElement = webElement;
    }

    public Actions getActions() {
        return ActionsHolder.instance;
    }

    private static class ActionsHolder {
        private static final Actions instance = new Actions(Browser.getDriver());
    }

    public By getLocator() {
        return locator;
    }

    private WebElement getWebElement() {
        webElement = Browser.getDriver().findElement(locator);
        return webElement;
    }

    public AbstractElement moveToElement() {
        logger.info("Move to element in main " + getWebElement());
        getActions().moveToElement(getWebElement()).perform();
        return this;
    }

    public void chooseRandomGame(By locatorList) {
        List<WebElement> selectValues = getWebElement().findElements(locatorList);
        waitUntilVisibilityOfAllElements(selectValues);
       // System.out.println(selectValues.size());
        int randomNumber = new Random().nextInt(10);
        int i = 0;
        for (WebElement webElement : selectValues) {
            if (i == randomNumber) {
                webElement.click();
                break;
            }
            i++;
        }
    }

    public GamePage getRandomGame(){
        List<WebElement> webElementList = Browser.getDriver().findElements(By.id("TopSellersRows"));
        //  webElementList.add(releasedGame.getAttribute("data-ds-appid"));
      //  webElementList.addAll(getWebElement().findElements(By.id("TopSellersRows")));
        /*List<String> idList = new ArrayList<>();
        for(int i= 0; i < webElementList.size(); i++){
            idList.add(webElementList.get(i).getAttribute("data-ds-appid"));
        }*/
       //  idList.get((int) (Math.random()+webElementList.size()));
        System.out.println(webElementList.size());
        webElementList.get((int) (Math.random() * (webElementList.size()-1))).click();
        return new GamePage();
    }

    public void click() {
        logger.info("Wait until element " + webElement + " to be clickable and waitAndClickAction");
        waitUntilClickable(webElement).click();
    }

    public String getText() {
        logger.info("Get text from element " + webElement);
        return webElement.getText();
    }

    public String getAttribute(String attribute) {
        logger.info("Get attribute " + attribute + " from element " + webElement);
        return webElement.getAttribute(attribute);
    }

    private WebElement waitUntilClickable(WebElement webElement) {
        return new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private WebElement waitUntilVisibilityOfElement(WebElement webElement) {
        return new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    private List <WebElement> waitUntilVisibilityOfAllElements(List<WebElement> webElements) {
        return new WebDriverWait(Browser.getDriver(), WAIT_TIME_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

}
