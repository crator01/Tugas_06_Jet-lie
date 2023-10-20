package CucumberTest.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseUrl ="https://www.saucedemo.com/";

    @Given("User sudah melakukan login")
public void user_sudah_melakukan_login() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.get(baseUrl);
    String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
    Assert.assertEquals(loginPageAssert,"Swag Labs");

    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    String LoginSuccess = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    Assert.assertEquals(LoginSuccess,"Products");

}


    @When("User memilih side menu")
    public void user_memilih_side_menu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

    }

    @And("User memilih button logout")
    public void user_memilih_button_logout() {
        driver.findElement(By.id("logout_sidebar_link")).click();

    }

    @Then("User berhasil logout")
    public void user_berhasil_logout() {
        String logoutPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(logoutPageAssert, "Swag Labs");

    }
}







