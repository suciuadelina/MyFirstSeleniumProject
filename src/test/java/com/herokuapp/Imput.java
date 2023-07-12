package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Imput {
    @Test
    public void imputTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/inputs";
        driver.get(url);
        driver.manage().window().maximize();

        //add number to input
        WebElement inputNumber= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input"));
        inputNumber.click();
        inputNumber.sendKeys("250");
        inputNumber.clear();

        //verify input value
        Assert.assertTrue(inputNumber.isDisplayed());
        driver.close();
    }
}
