package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;


public class TestCase1 {

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

    @Given("the user is on the Saucedemo login page on Test1")
    public void theUserIsOnTheSaucedemoLoginPageOnTest1() {
        driver.get("https://www.saucedemo.com");
    }

    @When("the user enters valid username and password")
    public void theUserEntersValidUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("the user clicks the login button on Test1")
    public void theUserClicksTheLoginButtonOnTest1() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should be redirected to the product page")
    public void theUserShouldBeRedirectedToTheProductPage() {
        assertTrue(driver.getCurrentUrl().contains("/inventory.html"));
        driver.quit();
    }

    @Then("the user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {
       return;
    }
}