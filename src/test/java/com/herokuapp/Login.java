package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
    @Test
    public void loginTest(){
        //open page
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        //enter username
        WebElement usernameImput= driver.findElement(By.id("username"));
        usernameImput.sendKeys("tomsmith");
        //enter password
        WebElement passwordImput= driver.findElement(By.name("password"));
        passwordImput.sendKeys("SuperSecretPassword!");
        //click login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        //WebElement loginButton = driver.findElement(By.tagName("button"));
        //WebElement loginButton = driver.findElement(By.classname("radius"));
        loginButton.click();

        //verificare
        String secureUrl ="https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(secureUrl,driver.getCurrentUrl());

        //verificare mesaj de succes
        String succesMesage= "You logged into a secure area!";
        WebElement successAlert = driver.findElement(By.id("flash"));
        successAlert.getText();
        Assert.assertTrue(successAlert.getText().contains(succesMesage));

        //verificare button logout
        WebElement logoutButton = driver.findElement(By.className("icon-signout"));
        Assert.assertTrue(logoutButton.isDisplayed());

        //inchidere pagina
         driver.close();
    }
}