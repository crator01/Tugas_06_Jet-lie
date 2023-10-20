import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SauceDemo {
    @Test
    public void open_browser (){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");


        //  driver.close();

    }
    @Test
    public void success_login (){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String LoginSuccess = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(LoginSuccess,"Products");



    }

    @Test
    public void failed_login(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login-button")).click();

        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void filter_price_low_to_high (){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

        WebElement element = driver.findElement(By.id("user-name"));
        WebElement element2 = driver.findElement(By.id("login-button"));
        element.click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        element.getText();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        element.getText();
        element2.isDisplayed();
        driver.findElement(By.id("login-button")).click();
        driver.findElements(By.cssSelector("Select.product_sort_container option")).get(2).click();
        java.util.List<WebElement> price= driver.findElements(By.className("inventory_item_price"));
        System.out.println(price.size());

        ArrayList<String> priceList = new ArrayList<String>();
        for (WebElement webElement : price) {
            priceList.add(webElement.getText());
        }
        System.out.println(priceList);


//        if(!ascendingCheck(priceList)){
//            Assert.fail("Not is ascending order");
//        }

    }



    @Test
    public void filter_price_high_to_low (){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

        WebElement element = driver.findElement(By.id("user-name"));
        WebElement element2 = driver.findElement(By.id("login-button"));
        element.click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        element.getText();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        element.getText();
        element2.isDisplayed();
        driver.findElement(By.id("login-button")).click();
        driver.findElements(By.cssSelector("Select.product_sort_container option")).get(3).click();


    }

    @Test
    public void filter_name_z_to_a (){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

        WebElement element = driver.findElement(By.id("user-name"));
        WebElement element2 = driver.findElement(By.id("login-button"));
        element.click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        element.getText();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        element.getText();
        element2.isDisplayed();
        driver.findElement(By.id("login-button")).click();
        driver.findElements(By.cssSelector("Select.product_sort_container option")).get(1).click();


    }

    @Test
    public void add_to_cart (){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();

        WebElement remove_button= driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        Assert.assertEquals(true,remove_button.isDisplayed());

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        String successAddCart = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(successAddCart,"Your Cart");



    }

    @Test
    public void logout () throws InterruptedException {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();


    }
}


