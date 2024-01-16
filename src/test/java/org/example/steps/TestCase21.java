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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class TestCase21 {
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

    @Given("the user is on the product page Test21")
    public void theUserIsOnTheProductPageTest4() {
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user selects sort by price high to low")
    public void theUserSelectsSortByPriceHighToLow() {
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");
    }

    @Then("the products should be displayed in descending order of price")
    public void theProductsShouldBeDisplayedInAscendingOrderOfPrice() {
        List<WebElement> items = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = items.stream()
                .map(e -> Double.parseDouble(e.getText().substring(1)))
                .collect(Collectors.toList());
        for (int i = 0; i < prices.size() - 1; i++) {
            assertTrue("Products are not sorted by price in descending order",
                    prices.get(i) >= prices.get(i + 1));
        }

    }

    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

}
