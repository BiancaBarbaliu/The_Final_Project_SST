package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase8 {
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

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @When("the user clicks on the checkout button")
    public void theUserClicksOnTheCheckoutButton() {
//        WebElement checkoutLink = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
//        checkoutLink.click();
    }

    @Then("the user should be taken to the checkout step one page")
    public void theUserShouldBeTakenToTheCheckoutStepOnePage() {
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertTrue("User is not on the checkout step one page.", currentUrl.contains("https://www.saucedemo.com/checkout-step-one.html"));
    }


    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
