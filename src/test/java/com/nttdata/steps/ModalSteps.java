package com.nttdata.steps;

import com.nttdata.page.AddProductPage;
import com.nttdata.page.ModalPage;
import org.openqa.selenium.WebDriver;

public class ModalSteps {

    WebDriver driver;

    public ModalSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBuyButton(){
        this.driver.findElement(ModalPage.buyButton).click();
    }

    public double getPriceTotalCalculated(){
        return Double.parseDouble(this.driver.findElement(ModalPage.priceTotalCalculated).getText().trim());
    }

    public double getPriceCalculated(){
        return Double.parseDouble(this.driver.findElement(ModalPage.priceCalculated).getText().trim());
    }

    public int getQuantityCalculated(){
        return Integer.parseInt(this.driver.findElement(ModalPage.quantityCalculated).getText().trim());
    }

    public String getHeaderText(){
        return this.driver.findElement(ModalPage.headerSuccess).getText().trim();
    }

}
