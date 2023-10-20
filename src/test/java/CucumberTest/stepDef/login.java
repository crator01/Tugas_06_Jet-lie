package CucumberTest.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User membuka browser")
    public void User_membuka_browser1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("User menginput url login")
    public void userMenginputUrlLogin() {
        driver.get(baseUrl);
    }

    @And("User menginput username")
    public void userMenginputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User menginput password")
    public void user_menginput_password() {

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    }

    @And("User memilih Login Button")
    public void userMemilihLoginButton1() {
        driver.findElement(By.id("login-button")).click();
    }


    @Then("User berhasil login")
    public void userBerhasilLogin() {
        String LoginSuccess = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(LoginSuccess, "Products");
    }


    @And("User diarahkan ke homepage")
    public void userDiarahkanKeHomepage() {
        String LoginSuccess = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(LoginSuccess, "Products");
    }

    @And("User menginput invalid password")
    public void userMenginputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("123456");
    }

    @Then("User mendapatkan error message")
    public void userMendapatkanErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @And("User tidak dapat masuk ke homepage")
    public void userTidakDapatMasukKeHomepage() {
        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }
}

