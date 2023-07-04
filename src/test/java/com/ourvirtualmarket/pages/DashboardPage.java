package com.ourvirtualmarket.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

public class DashboardPage extends BasePage{

    public String loginBtnOnHomePage = "//a[@class='link-lg']";
    ElementHandle element2 = page.querySelector(loginBtnOnHomePage);
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
        return page.isVisible(loginBtnOnHomePage);
    }
}
