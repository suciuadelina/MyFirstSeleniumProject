package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Download {
    @Test
    public void download() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/download";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement dummyDownload = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
        dummyDownload.click();
        driver.close();
    }
}
