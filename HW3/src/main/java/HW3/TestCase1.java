package HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL="https://omoimot.ru/login?back_url=https%3A%2F%2Fomoimot.ru";

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        login();

        driver.quit();
    }

    private static void login(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/input[2]")).sendKeys("olgaheadlong@yandex.ru");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/input[3]")).sendKeys("Queen1975");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div/button")).click();
    }
}
