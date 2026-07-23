package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.SharedContext;

public class Hooks {
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        SharedContext.driver = new ChromeDriver(options);

        //SharedContext.driver.manage().window().maximize();
        SharedContext.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @After
    public void tearDown() {
        if (SharedContext.driver != null) {
            SharedContext.driver.quit();
        }
    }
}
