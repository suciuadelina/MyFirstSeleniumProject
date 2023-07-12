package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout {
    @Test
    public void logout() {
        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();

        //enter username
        WebElement usernameImput = driver.findElement(By.id("username"));
        usernameImput.sendKeys("tomsmith");

        //enter password
        WebElement passwordImput = driver.findElement(By.name("password"));
        passwordImput.sendKeys("SuperSecretPassword!");

        //click login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();

        //click logout
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        logoutButton.click();

        //verificare mesaj de succes
        String succesMesage= "You logged out of the secure area!";
        WebElement successAlert = driver.findElement(By.id("flash"));
        Assert.assertTrue(successAlert.getText().contains(succesMesage));
        driver.close();
    }

}
