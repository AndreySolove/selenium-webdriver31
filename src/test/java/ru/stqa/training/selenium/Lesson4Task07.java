package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Lesson4Task07  extends TestBase {

    @Test
    public void duckTest() throws InterruptedException {

        driver.get("http://localhost/litecart/en/");

        String[] boxType = {"box-most-popular", "box-campaigns", "box-latest-products"};
        String locator, itemName, stickerName;
        int itemsCount, stickerCount;
        WebElement item;

        for (String box : boxType) {
            System.out.println("*** " + box + " ***");
            locator = "//div[@id='" + box + "']";
            itemsCount = driver.findElements(By.xpath(locator)).size();
            if (itemsCount > 0) {
                for (int i = 1; i <= itemsCount; i++) {
                    item = driver.findElement(By.xpath(locator + "[" + i + "]"));
                    stickerCount = item.findElements(By.xpath("//div[contains(@class,'sticker')]")).size();
                    itemName = item.findElement(By.xpath(".//div[@class='name']")).getText();
                    if (stickerCount == 1) {
                        stickerName = item.findElement(By.xpath(".//div[@title]")).getText();
                        System.out.println("ALL RIGHT! The item " + itemName + " has sticker " + stickerName.toUpperCase());
                    }
                    else if (stickerCount > 1)
                        System.out.println("ERROR! The item " + itemName + " has MORE than one sticker");
                    else
                        System.out.println("ERROR! The item " + itemName + " WITHOUT sticker");
                }
            }
        }
    }

}
