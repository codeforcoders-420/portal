package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
=======
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
>>>>>>> 6c7a67383e7136820f0710efe8e17167810c2736

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
<<<<<<< HEAD
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver.set(new EdgeDriver(options));
=======
        // Automatically detect and download the compatible ChromeDriver version
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode
        options.addArguments("--disable-notifications"); // Disable notifications
        
        driver.set(new ChromeDriver(options));
>>>>>>> 6c7a67383e7136820f0710efe8e17167810c2736
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}


