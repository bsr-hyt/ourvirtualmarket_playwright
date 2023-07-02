package com.ourvirtualmarket.pages;

import com.microsoft.playwright.Page;
import com.ourvirtualmarket.utilities.ConfigurationReader;

import static com.ourvirtualmarket.utilities.Driver.getPage;

public class LoginPage extends BasePage{

    public String EMAIL_INPUT_SELECTOR = "#email";
    public String PASSWORD_INPUT_SELECTOR = "#pass";
    public String LOGIN_BUTTON_SELECTOR = "#send2";

    public LoginPage(Page page) {
        super(page);
    }

    public void login() {
        DashboardPage dashboardPage = new DashboardPage(getPage());
        dashboardPage.closePopUp();
        dashboardPage.element2.click();
        page.fill(EMAIL_INPUT_SELECTOR, ConfigurationReader.get("userEmail"));
        page.fill(PASSWORD_INPUT_SELECTOR, ConfigurationReader.get("password"));
        page.click(LOGIN_BUTTON_SELECTOR);
    }

}
