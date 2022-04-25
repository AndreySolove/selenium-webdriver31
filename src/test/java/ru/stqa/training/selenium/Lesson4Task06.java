package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Lesson4Task06 extends TestBase {

    private WebElement findPage(WebDriver driver, int i){
        WebElement link = driver.findElement(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-'][" + i + "]"));
        return link;
    }

    private void checkHeader(WebDriver driver, String pageName){
        String h1;
        String result = "The page " + pageName;
        if (isElementPresent(driver, By.xpath("//h1"))) {
            h1 = driver.findElement(By.xpath("//h1")).getText();
            result += " have a header " + h1 + ".";
        }
        else
            result += " not have header h1";
        System.out.println(result);
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Test
    public void h1Test() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int menuItem =  driver.findElements(By.xpath("//li[@id = 'app-']")).size();
        int docsCount;
        String pageName;
        WebElement row, link;
        for (int i=1; i<=menuItem; i++)  {
            link = findPage(driver, i);
            pageName = link.findElement(By.xpath(".//span[@class='name']")).getText();
            link.click();
            link = findPage(driver, i);
            docsCount = link.findElements(By.xpath("//ul[@class='docs']/li[@id]")).size();
            if (docsCount > 0) {
                for (int j=1; j<=docsCount; j++) {
                    link = findPage(driver, i);
                    row = link.findElement(By.xpath("//ul[@class='docs']/li[@id][" + j + "]"));
                    pageName = row.findElement(By.xpath(".//span[@class='name']")).getText();
                    row.click();
                    checkHeader(driver, pageName);
                    Thread.sleep(200);
                }
            }
            else {
                checkHeader(driver, pageName);
            }
            Thread.sleep(300);
        }
    }
}
