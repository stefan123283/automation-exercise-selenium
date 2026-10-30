package com.stefan.automation.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {

    private static final String HEADLESS_MODE = ConfigReaderManager.getProperty("headlessMode");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        if (HEADLESS_MODE.equals("enabled")) {
            options.addArguments("--headless");
            Log.info("Initiating Chrome driver instance with headless mode enabled");
        } else {
            Log.info("Initiating Chrome driver instance with headless mode disabled");
        }
        driver = new ChromeDriver(options);
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }

    public void quitTheDriver() {
        Log.info("Closing browser session");
        driver.quit();
        driver = null;
        instance = null;
    }

}
