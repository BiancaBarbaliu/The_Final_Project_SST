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

import java.util.Arrays;
import java.util.List;

public class TestCase13 {
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

    @Given("the user is on the product page TestCase13")
    public void theUserIsOnTheProductPageTestCase13() {
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user adds multiple products to the shopping cart")
    public void theUserAddsMultipleProductsToTheShoppingCart() {
        List<String> productsToAdd = Arrays.asList("//*[@id=\"add-to-cart-sauce-labs-backpack\"]", "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
        for (String productPath : productsToAdd) {
            driver.findElement(By.xpath(productPath)).click();
        }
    }

    @Then("all selected products should be present in the shopping cart")
    public void allSelectedProductsShouldBePresentInTheShoppingCart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        Assert.assertTrue(driver.findElement(By.id("item_4_title_link")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("item_0_title_link")).isDisplayed());
        driver.quit();
    }

    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
