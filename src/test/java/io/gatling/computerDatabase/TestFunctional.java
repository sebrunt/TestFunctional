package io.gatling.computerDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class TestFunctional {

    public ChromeDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Start tests");

    }

    @Test
    public void actionTest() {

        driver.get("http://computer-database.gatling.io/computers");
        WebElement element = driver.findElement(By.id("add"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click(element);
        builder.perform();

    }

    @Test
    public void inputTest() {

        driver.get("http://computer-database.gatling.io/computers/new");
        WebElement computerName = driver.findElement(By.id("name"));
        computerName.sendKeys("Vladyslav Palamarchuk");
        WebElement introduced = driver.findElement(By.id("introduced"));
        introduced.sendKeys("2011-01-25");
        WebElement discontinued = driver.findElement(By.id("discontinued"));
        discontinued.sendKeys("2021-01-25");
        Select select = new Select(driver.findElement(By.id("company")));
        select.selectByVisibleText("IBM");
        select.selectByIndex(13);

    }

    @After
    public void close() {
        driver.quit();
    }
}
