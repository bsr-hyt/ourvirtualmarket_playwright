package com.ourvirtualmarket.pages;

import com.microsoft.playwright.Page;
import com.ourvirtualmarket.utilities.ConfigurationReader;

import static com.ourvirtualmarket.utilities.Driver.getPage;

public class LoginPage extends BasePage{

    //String Locators:
    public String inputEmailBox = "#email";
    public String password = "#pass";
    public String loginbtn = "#send2";

    public String logoutLink = "//a[@class='link-lg']";


    //page constructor:
    public LoginPage(Page page) {
        super(page);
    }


    //page actions/methods:
    public void login() {
        DashboardPage dashboardPage = new DashboardPage(getPage());
        dashboardPage.closePopUp();
        dashboardPage.element2.click();
        page.fill(inputEmailBox, ConfigurationReader.get("userEmail"));
        page.fill(password, ConfigurationReader.get("password"));
        page.click(loginbtn);
        page.locator(logoutLink).isVisible();
    }

    public void login(String emaill,String passwordd) {
        DashboardPage dashboardPage = new DashboardPage(getPage());
        dashboardPage.closePopUp();
        dashboardPage.element2.click();
        page.fill(inputEmailBox, emaill);
        page.fill(password, passwordd);
        page.click(loginbtn);
        page.locator(logoutLink).isVisible();
    }

}
