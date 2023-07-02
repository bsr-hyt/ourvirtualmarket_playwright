package com.ourvirtualmarket.tests;

import com.ourvirtualmarket.pages.DashboardPage;
import com.ourvirtualmarket.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ourvirtualmarket.utilities.Driver.getPage;

public class LoginTest extends TestBase{
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Test
    public void testLogin() {
        test = extent.createTest("Login Function Test");
        loginPage = new LoginPage(getPage());
//        dashboardPage = new DashboardPage(getPage());
        loginPage.login();
        Assert.assertTrue(dashboardPage.isLogoutButtonVisible(), "Logout button is not visible.");
        test.pass("login to account with valid email and valid password");
    }
}





