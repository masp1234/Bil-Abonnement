package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.DamageReportRepository;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


//for at kunne bruge @Order annotation
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DamagesTest {

    private static DamageReportRepository damageReportRepository;
    private static WebDriver driver;
    private static DamageReport testDamageReport;
    private static String testChassisNumber;
    private static String testRegistrationNumber;



    @BeforeAll()
    public static void setupAndPing() {
        WebDriverManager.chromedriver().setup();

        damageReportRepository = new DamageReportRepository();

        testChassisNumber = "123POLICETEST";
        testRegistrationNumber = "123POLICE";

        testDamageReport = new DamageReport(15000, "2022-10-31",
                "totalskadet", testChassisNumber, 350000);

        login();

        driver.close();
    }

    public static void login() {
        driver = new ChromeDriver();

        driver.get("https://bil-abonnement-projekt.herokuapp.com");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("bobsenskade");
        password.sendKeys("123123");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test
    @Order(1)
    public void createDamageReport() {
        login();

        driver.get("https://bil-abonnement-projekt.herokuapp.com/show-damagereport/"
                + testChassisNumber + "/" + testRegistrationNumber);

        WebElement damageDescription = driver.findElement(By.id("description"));
        damageDescription.sendKeys(testDamageReport.getDescription());

        WebElement createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));

        createDamageReportButton.click();

        WebElement showDamageReportButton = driver.findElement(By.id("show-damage-report-button"));
        showDamageReportButton.click();








    }
    @AfterAll
    public static void cleanup() {
        damageReportRepository.deleteAllDamageReportsByChassisNumber(testChassisNumber);
    }
}
