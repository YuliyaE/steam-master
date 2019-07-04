package com.epam.tat.steam.test;

import com.epam.tat.steam.enums.header.LanguageMenu;
import com.epam.tat.steam.enums.header.MainMenu;
import com.epam.tat.steam.form.page.CartPage;
import com.epam.tat.steam.form.page.GamePage;
import com.epam.tat.steam.form.page.GamesListPage;
import com.epam.tat.steam.form.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveGameFromCart extends BaseTest {

    @Test
    public void removeGameFromCart() {
        GamesListPage gamesListPage = new MainPage()
                .changeMainPageLanguage(LanguageMenu.ENGLISH)
                .navigateToGames(MainMenu.GAMES);
        gamesListPage.chooseGame();
        gamesListPage.addToCart();
        CartPage cartPage = new CartPage().removeGame();
        Assert.assertEquals(cartPage.getCartPageStatusMessage(), "YOUR ITEM HAS BEEN REMOVED!");
        Assert.assertEquals(cartPage.getEstimatedTotalCost(), "$0.00 USD");
    }
}
