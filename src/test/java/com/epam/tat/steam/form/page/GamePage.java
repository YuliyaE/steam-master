package com.epam.tat.steam.form.page;

import com.epam.tat.framework.webdriver.element.AbstractElement;
import com.epam.tat.framework.webdriver.element.Button;
import com.epam.tat.framework.webdriver.element.Label;
import com.epam.tat.framework.webdriver.element.TextField;
import com.epam.tat.steam.model.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class GamePage extends BasePage{

    private final Logger LOGGER = LogManager.getLogger();

    private By topSellersRowsListRandom = By.id("TopSellersRows");

    //  private final By topSellersRowsList = By.id("TopSellersRows");
    private final By topSellersRowsList = By.xpath("//*[@class='tab_item   app_impression_tracked']");


    @FindBy(xpath = "//*[@id='TopSellersRows']/*[@data-ds-appid='578080']")
    private Button topSellersRowsGame;


    @FindBy(xpath = "//*[@class='btn_addtocart']")
    private Button addToCart;


    public CartPage addToCart() {
    //    topSellersRowsGame.click();
        // viewPage.click(); // if 18+ appears, use this line
        addToCart.click();
        return new CartPage();
    }


}
