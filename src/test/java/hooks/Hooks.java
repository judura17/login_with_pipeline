package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SharedContext;

public class Hooks {
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        SharedContext.driver = new ChromeDriver();
        SharedContext.driver.manage().window().maximize();
        SharedContext.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @After
    public void tearDown() {
        if (SharedContext.driver != null) {
            SharedContext.driver.quit();
        }
    }
}
