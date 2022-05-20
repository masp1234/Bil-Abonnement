package com.example.bilabonnement.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

class HomeControllerTest {

    @BeforeAll
    //Skal være static
    public static void setup() {
        //sætter automatisk WebDriver op, så man ikke skal downloade filen og bekymre sig om, om det er mac eller win
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://bil-abonnement-projekt.herokuapp.com");

        //  WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        // WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));

        username.sendKeys("Bobsen");
        password.sendKeys("123123");
        loginButton.click();


        WebElement createCustomerButton = driver.findElement(By.className("createCustomer"));
        createCustomerButton.click();

        WebElement cpr = driver.findElement(By.id("cpr"));
        cpr.sendKeys("2121212");

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Henning");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Henningsen");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Henning@gmail.com");

        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys("9349354");

        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("dfsfsf vej 21");

        WebElement zipCode = driver.findElement(By.id("zipCode"));
        zipCode.sendKeys("2630");

        WebElement createCustomerSubmitButton = driver.findElement(By.className("button-submit"));

        createCustomerSubmitButton.click();

    }

}