package CucumberTest.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class filter {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User sudah berada di halaman home")
    public void user_sudah_berada_di_halaman_home(){

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

    @When("User mengklik icon filter")
    public void userMengklikIconFilter() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
    }

    @And("memilih filter low to high")
    public void memilihFilterLowToHigh() {
        driver.findElements(By.cssSelector("Select.product_sort_container option")).get(2).click();
    }

    @Then("Produk akan tersortir")
    public void produkAkanTersortir() {

        java.util.List<WebElement> price= driver.findElements(By.className("inventory_item_price"));
        System.out.println(price.size());
        ArrayList<String> priceList = new ArrayList<String>();
        for (WebElement webElement : price) {
            priceList.add(webElement.getText());
        }
        System.out.println(priceList);


    }
}
