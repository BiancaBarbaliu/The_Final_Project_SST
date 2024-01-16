package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase9 {
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

    @Given("the user is on the checkout step one page")
    public void theUserIsOnTheCheckoutStepOnePage() {
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    @When("the user enters payment information")
    public void theUserEntersPaymentInformation() {
        driver.findElement(By.id("first-name")).sendKeys("Bianca");
        driver.findElement(By.id("last-name")).sendKeys("Barbaliu");
        driver.findElement(By.id("postal-code")).sendKeys("515600");
    }

    @And("the user clicks on the continue button")
    public void theUserClicksOnTheContinueButton() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Then("the user should be taken to the checkout step two page")
    public void theUserShouldBeTakenToTheCheckoutStepTwoPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on the checkout step two page.", currentUrl.contains("https://www.saucedemo.com/checkout-step-two.html"));
    }
    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
