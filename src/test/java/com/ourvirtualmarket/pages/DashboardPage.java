package com.ourvirtualmarket.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class DashboardPage extends BasePage{

    public String LOGIN_BUTTON = "//a[@class='link-lg']";
    ElementHandle element2 = page.querySelector(LOGIN_BUTTON);
    //ElementHandle element = page.querySelector("xpath=//a[@class='link-lg']");
    public String CLOSE_POPUP_BUTTON = "//button[@title='Close']";



    public DashboardPage(Page page) {
        super(page);
    }

    public void closePopUp() {
        page.click(CLOSE_POPUP_BUTTON);
    }

    public boolean isLogoutButtonVisible() {
        page.waitForTimeout(2000);
        return page.isVisible(LOGIN_BUTTON);
    }
}
