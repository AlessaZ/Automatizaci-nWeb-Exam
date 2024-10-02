package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeEmail(String email){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar hasta que el elemento se encuentre
        WebElement emailElement = wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.emailInput));
        emailElement.sendKeys(email);

    }

    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }


    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }

}
