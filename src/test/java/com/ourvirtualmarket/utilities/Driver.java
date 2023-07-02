package com.ourvirtualmarket.utilities;

import com.microsoft.playwright.*;

public class Driver {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    private Driver() {}

    //initialize() metodu Playwright'ı başlatır, belirtilen tarayıcıyı seçer ve bir sayfa oluşturur.
    public static void initialize() {
        try {
            playwright = Playwright.create();
            String browserName = ConfigurationReader.get("browser");

            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setHeadless(false); // Tarayıcının başlatılmasını headless olarak ayarla

            BrowserType browserType;
            switch (browserName) {
                case "chrome":
                    browserType = playwright.chromium();
                    break;
                case "firefox":
                    browserType = playwright.firefox();
                    break;
                case "webkit":
                    browserType = playwright.webkit();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser name: " + browserName);
            }

            browser = browserType.launch(launchOptions);
            context = browser.newContext();
            page = context.newPage();

            String url = ConfigurationReader.get("url");
            page.navigate(url);
        } catch (PlaywrightException e) {
            e.printStackTrace();
        }
    }

    //getPage() metodu, mevcut sayfayı döndürür.
    public static Page getPage() {
        return page;
    }

    //close() metodu ise tarayıcıyı ve Playwright örneğini kapatır.
    public static void close() {
        browser.close();
        playwright.close();
    }

    //Driver.initialize() yöntemini kullanarak tarayıcıyı başlatabilir
    //Driver.getPage() yöntemini kullanarak mevcut sayfaya erişebilirsin
}

