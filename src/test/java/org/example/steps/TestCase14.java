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
public class TestCase14 {
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

    @Given("the user has added products to the cart TestCase14")
    public void theUserHasAddedProductsToTheCartTestCase14() {
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        WebElement cartLink = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        cartLink.click();
    }

    @When("the user removes a product from the cart")
    public void theUserRemovesAProductFromTheCart() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @Then("the product should no longer be visible in the shopping cart")
    public void theProductShouldNoLongerBeVisibleInTheShoppingCart() {
        Assert.assertTrue(driver.findElements(By.id("item_4_title_link")).isEmpty());
    }
    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
