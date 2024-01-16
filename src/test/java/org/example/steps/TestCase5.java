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

public class TestCase5 {
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

    @Given("the user is on the product page")
    public void theUserIsOnTheProductPage() {
        // Assuming the user is already logged in and navigated to the product page.
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user clicks on a product's name")
    public void theUserClicksOnAProductName() {
         //Click on the first product's name. You might want to make this more specific.
        WebElement firstProductName = driver.findElement(By.className("inventory_item_img"));
        firstProductName.click();
    }

    @Then("the product's details should be displayed")
    public void theProductSDetailsShouldBeDisplayed() {
        // Check if the product details are displayed. This can include checking for the presence of a specific element that only exists on the details page.
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
