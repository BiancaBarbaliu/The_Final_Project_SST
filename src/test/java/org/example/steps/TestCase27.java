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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase27 {
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

    @Given("the user is on the product page TestCase27")
    public void theUserIsOnTheProductPageTestCase27() {
        // Assuming the user is already logged in and navigated to the product page.
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user clicks on a product's name TestCase27")
    public void theUserClicksOnAProductNameTestCase27() {
        WebElement secondProductName = driver.findElement(By.className("inventory_item_img"));
        secondProductName.click();
    }

    @Then("the product's details should be displayed TestCase27")
    public void theProductSDetailsShouldBeDisplayed() {
        WebElement productDetails = driver.findElement(By.className("inventory_details"));
        Assert.assertTrue(productDetails.isDisplayed());
    }

    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

}
