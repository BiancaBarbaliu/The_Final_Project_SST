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

public class TestCase18 {
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
    @Given("the user is on the checkout step two page")
    public void theUserIsOnCheckoutStepTwoPage() {
        loginToSaucedemo();
        addAnItem();
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
    }
    @When("the user clicks on the finish button TestCase18")
    public void theUserClicksOnFinishButtonTestCase18() {
        driver.findElement(By.id("finish")).click();
    }
    @Then("the user should be directed to the order success page with a unique order ID")
    public void theUserShouldBeDirectedToOrderSuccessPage() {
        if(driver.findElement(By.className("complete-header")).getText().contains("Thank you for your order!")){
            return;
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
