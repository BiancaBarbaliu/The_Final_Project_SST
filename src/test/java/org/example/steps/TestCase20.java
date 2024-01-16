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
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestCase20 {
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

    @Given("the user is on the product page TestCase20")
    public void theUserIsOnTheProductPageTestCase20() {
        loginToSaucedemo();
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user selects sort by name from A to Z")
    public void theUserSelectsSortByNameFromZToA() {
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (A to Z)");
    }

    @Then("the products should be displayed in ascending alphabetical order")
    public void theProductsShouldBeDisplayedInDescendingOrder() {
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List<String> productNames = products.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedProductNames = new ArrayList<>(productNames);
        sortedProductNames.sort(Comparator.naturalOrder());

        Assert.assertEquals("Products should be sorted in ascending order", sortedProductNames, productNames);
        driver.quit();
    }

    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
