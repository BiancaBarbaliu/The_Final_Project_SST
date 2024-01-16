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

public class TestCase29 {
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

    @Given("the user is on the product page TestCase29")
    public void theUserIsOnTheProductPageTestCase29() {
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user clicks on a product's name TestCase29")
    public void theUserClicksOnAProductNameTestCase29() {
        WebElement fourthProductName = driver.findElement(By.className("inventory_item_img"));
        fourthProductName.click();
    }

    @Then("the product's details should be displayed TestCase29")
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
