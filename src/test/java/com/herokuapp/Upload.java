package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Upload {
    @Test
    public void upload(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/upload";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\adeli\\IdeaProjects\\MyFirstSeleniumProject\\src\\test\\resources\\Upload.txt");

        WebElement fileSubmitButton = driver.findElement(By.id("file-submit"));
        fileSubmitButton.click();
        WebElement headerMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String text = "File Uploaded!";
        Assert.assertTrue(headerMessage.getText().contains(text));

       // WebElement uploadedFilesList = driver.findElement(By.id("uploaded-files"));
        //Assert.assertTrue(uploadedFilesList.getText().contains("upload.txt"));

        driver.close();
    }
}
