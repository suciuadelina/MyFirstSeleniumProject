package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class DragAndDrop {
    @Test
    public void dragAndDrop(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement A= driver.findElement(By.xpath("//*[@id=\"column-a\"]/header"));
        WebElement B= driver.findElement(By.xpath("//*[@id=\"column-b\"]/header"));

       Actions mutare= new Actions(driver);
        Action dragAndDrop;
        dragAndDrop = mutare.clickAndHold(A).moveToElement(B).release(B).build();

        dragAndDrop(A,B).perform();
    }
}
