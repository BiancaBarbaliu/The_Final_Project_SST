package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase12 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Given("the user is on the Saucedemo login page TestCase12")
    public void theUserIsOnTheSaucedemoLoginPageTestCase12(){
        driver.get("https://www.saucedemo.com");
    }

    @When("the user tries to login with a locked-out user account")
    public void theUserTriesToLoginWithALockedOutUserAccount(){
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should receive a locked-out user error message")
    public void theUserShouldReceiveALockedOutUserErrorMessage() {
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"))
                .getText();
        Assert.assertTrue(errorMessage.contains("Sorry, this user has been locked out."));
        driver.quit();
    }
}
