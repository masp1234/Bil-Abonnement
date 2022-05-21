package com.example.bilabonnement.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

class HomeControllerTest {

    static WebDriver driver;

    @BeforeAll
    //Skal være static
    public static void setupAndPing() {
        //sætter automatisk WebDriver op, så man ikke skal downloade filen og bekymre sig om, om det er mac eller win
        WebDriverManager.chromedriver().setup();

        login();

        driver.close();
    }
    public static void login() {
        driver = new ChromeDriver();
        driver.get("https://bil-abonnement-projekt.herokuapp.com");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        username.sendKeys("Bobsen");
        password.sendKeys("123123");
        loginButton.click();



    }

    //Bliver nødt til at logge ind hver gang, da den åbner en ny "profil" uden cookies
    @Test
    public void createCustomer() {

        login();

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

        driver.close();

    }
    @Test
    public void createCar() {
        login();

        WebElement createCustomerButton = driver.findElement(By.className("createCar"));
        createCustomerButton.click();

        WebElement registrationNumber = driver.findElement(By.id("registrationNumber"));
        registrationNumber.sendKeys("REGNUMBER123");

        WebElement chassisNumber = driver.findElement(By.id("chassisNumber"));
        chassisNumber.sendKeys("CHASSISNUMBER123");

        WebElement make = driver.findElement(By.id("make"));
        make.sendKeys("Mercedes");

        WebElement model = driver.findElement(By.id("model"));
        model.sendKeys("EQS Sedan");

        WebElement color = driver.findElement(By.id("color"));
        color.sendKeys("Sølv");

        WebElement equipmentLevel = driver.findElement(By.id("equipmentLevel"));
        equipmentLevel.sendKeys("Ekstra +");

        WebElement registrationFee = driver.findElement(By.id("registrationFee"));
        registrationFee.sendKeys("30000");

        WebElement carEmission = driver.findElement(By.id("carEmission"));
        carEmission.sendKeys("100.5");

        WebElement link = driver.findElement(By.id("link"));
        link.sendKeys("https://www.mercedes-benz.dk/passengercars/mercedes-benz-cars/models/eqs/" +
                "saloon-v297/_jcr_content/image.MQ6.2.2x.20210819150545.png");

        WebElement createCarButton = driver.findElement(By.className("button-submit"));

        createCarButton.click();

        driver.close();



    }


}