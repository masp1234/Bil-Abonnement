package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Customer;
import com.example.bilabonnement.repositories.CarRepository;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


//for at kunne bruge @Order annotation
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HomeControllerTest {

    //static for at kunne tilgå dem i setup og cleanup (som skal være static)
    private static CarRepository carRepository;
    private static WebDriver driver;
    private static Car testCar;
    private static Customer testCustomer;

    @BeforeAll
    //Skal være static
    public static void setupAndPing() {
        //sætter automatisk WebDriver op, så man ikke skal downloade filen og bekymre sig om, om det er mac eller win
        WebDriverManager.chromedriver().setup();

        carRepository = new CarRepository();

        login();

        testCustomer = new Customer("2102901211", "Henning", "Henningsen",
                "Henning@gmail.com", "12345678", "testvej 123",
                "4000", "Roskilde");

        testCar = new Car("REGNUMBER123", "CHASSISNUMBER123",
                "Mercedes", "EQS Sedan", "Sølv", "Ekstra +",
                30000, 50.5, "available", "https://www.mercedes-benz.dk/passengercars/" +
                "mercedes-benz-cars/models/eqs/saloon-v297/_jcr_content/image.MQ6.2.2x.20210819150545.png");

        driver.close();
    }
    //Bliver nødt til at logge ind hver gang, da den åbner en ny "profil" uden cookies
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


    @Test
    @Order(1)
    public void createCustomer() {

        login();

        WebElement createCustomerButton = driver.findElement(By.className("createCustomer"));
        createCustomerButton.click();

        WebElement cpr = driver.findElement(By.id("cpr"));
        cpr.sendKeys(testCustomer.getCpr());

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(testCustomer.getFirstname());

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(testCustomer.getLastName());

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(testCustomer.getEmail());

        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys(testCustomer.getPhoneNumber());

        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys(testCustomer.getAddress());

        WebElement zipCode = driver.findElement(By.id("zipCode"));
        zipCode.sendKeys(testCustomer.getZipCode());

        WebElement createCustomerSubmitButton = driver.findElement(By.className("button-submit"));

        createCustomerSubmitButton.click();

        driver.close();

    }
    @Test
    @Order(2)
    public void createCar() {

        login();

        WebElement createCustomerButton = driver.findElement(By.className("createCar"));
        createCustomerButton.click();

        WebElement registrationNumber = driver.findElement(By.id("registrationNumber"));
        registrationNumber.sendKeys(testCar.getRegistrationNumber());

        WebElement chassisNumber = driver.findElement(By.id("chassisNumber"));
        chassisNumber.sendKeys(testCar.getChassisNumber());

        WebElement make = driver.findElement(By.id("make"));
        make.sendKeys(testCar.getMake());

        WebElement model = driver.findElement(By.id("model"));
        model.sendKeys(testCar.getModel());

        WebElement color = driver.findElement(By.id("color"));
        color.sendKeys(testCar.getColor());

        WebElement equipmentLevel = driver.findElement(By.id("equipmentLevel"));
        equipmentLevel.sendKeys(testCar.getEquipmentLevel());

        WebElement registrationFee = driver.findElement(By.id("registrationFee"));
        // konverterer double til string, da WebElement.sendKeys kun tager en String
        registrationFee.sendKeys(String.valueOf(testCar.getRegistrationFee()));

        WebElement carEmission = driver.findElement(By.id("carEmission"));
        carEmission.sendKeys(String.valueOf(testCar.getEmission()));

        WebElement link = driver.findElement(By.id("link"));
        link.sendKeys("https://www.mercedes-benz.dk/passengercars/mercedes-benz-cars/models/eqs/" +
                "saloon-v297/_jcr_content/image.MQ6.2.2x.20210819150545.png");

        WebElement createCarButton = driver.findElement(By.className("button-submit"));

        createCarButton.click();

        driver.close();



    }
    @Test
    @Order(3)
    public void createLease() {
        login();

        driver.get("https://bil-abonnement-projekt.herokuapp.com/lease/" + testCar.getRegistrationNumber());

        WebElement cprNumber = driver.findElement(By.id("cprNumber"));
        cprNumber.sendKeys(testCustomer.getCpr());

        WebElement price = driver.findElement(By.id("price"));
        price.sendKeys("4500");

        WebElement customerAccountNumber = driver.findElement(By.id("customerAccountNumber"));
        customerAccountNumber.sendKeys("2271255432342");

        WebElement customerRegNumber = driver.findElement(By.id("customerRegNumber"));
        customerRegNumber.sendKeys("2271");

        WebElement startDate = driver.findElement(By.id("startDate"));
        startDate.sendKeys("2022-10-02");

        WebElement endDate = driver.findElement(By.id("endDate"));
        endDate.sendKeys("2022-10-25");

        WebElement createLeaseButton = driver.findElement(By.className("button-submit"));

        createLeaseButton.click();

        driver.close();
    }

    @AfterAll
    public static void cleanup() {
        carRepository.deleteCarById(testCar.getRegistrationNumber());
    }


}