package com.epam.tat.framework.webdriver.element.header;

import com.epam.tat.framework.webdriver.element.AbstractElement;
import com.epam.tat.framework.webdriver.element.Element;
import org.openqa.selenium.By;

public class MenuLabel extends AbstractElement implements Element {
    public MenuLabel(By locator) {
        super(locator);
    }

    @Override
    public void click() {
        getActions().click().build().perform();
    }
}
