package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson4Task07  extends TestBase {

    @Test
    public void duckTest() throws InterruptedException {

        driver.get("http://localhost/litecart/en/");

        String locator = "li.product";
            List<WebElement> items = driver.findElements(By.xpath(locator));
            if (items.size() > 0) {
                for (WebElement item : items) {
                    int stickerCount = item.findElements(By.cssSelector("div.sticker")).size();
                    Assert.assertEquals(stickerCount, 1, "The number of stickers is not equal to one");
                }
            }
        }
    }


