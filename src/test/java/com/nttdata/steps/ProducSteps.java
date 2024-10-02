package com.nttdata.steps;

import com.nttdata.page.AddProductPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProducSteps {

    WebDriver driver;

    public ProducSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void typeQuantity(int quantity){
        WebElement quantityElement = this.driver.findElement(AddProductPage.quantity);
        quantityElement.sendKeys(Keys.CONTROL + "a");
        quantityElement.sendKeys(Keys.DELETE);
        quantityElement.sendKeys(String.valueOf(quantity));
    }

    public void clickAddButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(AddProductPage.addButton));
        addButton.click();
    }

    public void clickBuyButton(){
        this.driver.findElement(AddProductPage.buyButton).click();
    }

    public double getPriceTotalCalculated(){
        return Double.parseDouble(this.driver.findElement(AddProductPage.priceTotalCalculated).getText().replaceAll("[^0-9.]", "").trim());
    }

    public double getPriceCalculated(){
        return Double.parseDouble(this.driver.findElement(AddProductPage.priceCalculated).getText().replaceAll("[^0-9.]", "").trim());
    }

    public int getQuantityCalculated(){
        return Integer.parseInt(this.driver.findElement(AddProductPage.quantityCalculated).getText().trim());
    }

    public String getHeaderText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement headerSuccess = wait.until(ExpectedConditions.presenceOfElementLocated(AddProductPage.headerSuccess));
        return headerSuccess.getText().replaceAll("[^\\p{L}\\p{N}\\p{P}\\p{Z}]", "").trim();
    }

}
