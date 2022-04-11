package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://localhost/litecart/admin/");
        WebElement l = driver.findElement(By.name("username"));
        l.sendKeys("login");
        WebElement p = driver.findElement(By.name("password"));
        p.sendKeys("password");
        WebElement r = driver.findElement(By.name("remember_me"));
        r.click();
        WebElement log = driver.findElement(By.name("login"));
        log.click();
    }

    @AfterTest
    public void stop() {
        driver.quit();
    }
}