package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TestCase3 {

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

    @Given("the user is logged in to the Saucedemo")
    public void theUserIsLoggedInToTheSaucedemo() {
        loginToSaucedemo();
    }

    @When("the user navigates to the product page")
    public void theUserNavigatesToTheProductPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Then("the list of products should be displayed")
    public void theListOfProductsShouldBeDisplayed() {
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        Assert.assertFalse("The product list is not displayed", products.isEmpty());
    }

    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
