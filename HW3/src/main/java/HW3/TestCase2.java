package HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://omoimot.ru");

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/div[2]/header/div/div[2]/div[2]/a[1]"));
        WebElement webElement2 = driver.findElement(By.cssSelector("css=#category-btn > svg"));
        WebElement webElement3 = driver.findElement(By.cssSelector("css=.popover-content .roboto-light--15"));
        WebElement webElement4 = driver.findElement(By.id("id=journalSearch"));


        WebElement webElementError = driver.findElement(By.name("error"));

        List<WebElement> webElements = driver.findElements(By.name("error"));
        if(webElements.size()>1){
            //todo
        }

        webElement1.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("journal"));
        driver.navigate().to("https://omoimot.ru/journal");

        webElement2.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webElement3.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("search"));
        driver.navigate().to("https://omoimot.ru/journal/search");

        try {
            webElement4.sendKeys("harley");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }

        driver.quit();
    }
}
