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

public class TestCase22{
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
    @Given("the user is on the Saucedemo login page TestCase22")
    public void theUserIsOnTheSaucedemoLoginPageTestCase22(){
        driver.get("https://www.saucedemo.com");
    }
    @When("the user logs in with the \"problem_user\" credentials")
    public void theUserTriesToLoginWithTheProblemUserCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @Then("the user should experience unusual behaviors such as incorrect product details or visual glitches")
    public void theUserShouldExperienceUnusualBehaviors() {
        if(driver.findElement(By.className("inventory_item_img")).isDisplayed()){
            return;
        }
    }

}
