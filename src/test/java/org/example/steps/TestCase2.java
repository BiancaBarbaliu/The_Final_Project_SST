package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {
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

    @Given("the user is on the Saucedemo login page")
    public void theUserIsOnTheSaucedemoLoginPage() {
        driver.get("https://www.saucedemo.com");
    }

    @When("the user enters invalid username and password")
    public void theUserEntersInvalidUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("invalid");
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

}