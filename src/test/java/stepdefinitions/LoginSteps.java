package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import utils.SharedContext;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    LoginPage loginPage = new LoginPage(SharedContext.driver);

    @Given("Yo esté en la pagina de login de HRM")
    public void i_am_on_the_HRM_logon_page(){
        }

    @When("Ingrese el usuario y contraseña")
    public void enter_the_username_and_password(){
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
    }
    @And("Haga click en el boton ingresar")
    public void click_on_button_login(){
        loginPage.clickLoginButton();
    }
    @Then("El usuario debe de ver el dashboard")
    public void should_watch_the_dashboard(){
        loginPage.waitDashboard();
        Assert.assertTrue(SharedContext.driver.getCurrentUrl().contains("dashboard"));
        System.out.println("Login ejecutado");
    }

}
