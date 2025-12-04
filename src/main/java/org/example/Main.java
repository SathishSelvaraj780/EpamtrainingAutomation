package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
        driver.findElement(By.xpath("//a[@title='Cricket Teams']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href,'/cricket-team/india')]"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Stats']")).click();
        System.out.println("Successfully navigated to Stats");
        Thread.sleep(3000);
        List<WebElement> kholi = driver.findElements(By.xpath("//table[@class='w-full text-xs wb:text-sm']/tbody/tr[1]"));
        System.out.println(kholi.get(1).getText());
        }
        catch (Exception e){
            e.printStackTrace();
            }
        finally {
            driver.quit();
        }

    }
}