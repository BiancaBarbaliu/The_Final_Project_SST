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

public class TestCase17 {
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
    @Given("the user is on the checkout step two page TestCase17")
    public void theUserIsOnCheckoutStepTwoPageTestCase17() {
        loginToSaucedemo();
        addAnItem();
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
    }

    @When("the user reviews the order summary")
    public void theUserReviewsTheOrderSummary() {
        if(driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]")).isDisplayed()){
            return;
        }
    }

    @Then("the order summary should list all items, payment details, and the total cost")
    public void theOrderSummaryShouldListAllItemsPaymentDetailsAndTotalCost() {
        if(driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]")).isDisplayed()){
            if(driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[3]")).isDisplayed()){
                if (driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")).isDisplayed()){
                    return;
                }
            }
        }
    }

    private void loginToSaucedemo() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    private void addAnItem(){
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }
}
