package com.epam.tat.steam.form.page;

import com.epam.tat.framework.webdriver.element.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class GamePage extends BasePage{

    private final Logger LOGGER = LogManager.getLogger();

    @FindBy(xpath = "//*[@class='btn_addtocart']")
    private Button addToCart;


    public CartPage addToCart() {
        addToCart.click();
        return new CartPage();
    }


}
