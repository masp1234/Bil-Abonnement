package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.DamageReportRepository;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/*Martin*/


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DamagesTest {

    private static DamageReportRepository damageReportRepository;
    private static WebDriver driver;
    private static DamageReport testDamageReport;
    private static String testChassisNumber;
    private static String testRegistrationNumber;
    private static String baseUrl;



    @BeforeAll()
    public static void setupAndPing() {
        WebDriverManager.chromedriver().setup();

        damageReportRepository = new DamageReportRepository();

        testChassisNumber = "123POLICETEST";
        testRegistrationNumber = "123POLICE";

        testDamageReport = new DamageReport(15000, "2022-10-31",
                "totalskadet", testChassisNumber, 350000);

        baseUrl = "https://bil-abonnement-projekt.herokuapp.com/";

        login();
    }

    public static void login() {
        driver = new ChromeDriver();


        driver.get("https://bil-abonnement-projekt.herokuapp.com");

        driver.get(baseUrl);


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

        driver.get(baseUrl + "show-damagereport/" + testChassisNumber + "/" + testRegistrationNumber);

        WebElement damageReportDescription = driver.findElement(By.id("description"));
        damageReportDescription.sendKeys(testDamageReport.getDescription());

        WebElement createDamageReportButton = driver.findElement(By.id("create-damage-report-button"));

        createDamageReportButton.click();

    }
    @Test
    @Order(2)
    public void addAndDeleteDamages() {
        login();

        driver.get(baseUrl + "show-damagereport/" + testChassisNumber + "/" + testRegistrationNumber);

        WebElement showDamageReportButton = driver.findElement(By.id("show-damage-report-button"));
        showDamageReportButton.click();

        WebElement damageDescription = driver.findElement(By.id("description"));
        damageDescription.sendKeys("død motor");


        WebElement price = driver.findElement(By.id("price"));
        price.sendKeys("65000");
        WebElement createDamageButton = driver.findElement(By.className("button-submit2"));
        createDamageButton.click();

        WebElement secondDamageDescription = driver.findElement(By.id("description"));
        secondDamageDescription.sendKeys("smadret radio");

        WebElement secondPrice = driver.findElement(By.id("price"));
        secondPrice.sendKeys("1500");
        WebElement secondCreateDamageButton = driver.findElement(By.className("button-submit2"));
        secondCreateDamageButton.click();

        WebElement deleteDamageButton = driver.findElement(By.className("button-submit3"));
        deleteDamageButton.click();
    }
    @AfterAll
    public static void cleanup() {
        damageReportRepository.deleteAllDamageReportsByChassisNumber(testChassisNumber);

        driver.close();
        driver.quit();

    }
}
