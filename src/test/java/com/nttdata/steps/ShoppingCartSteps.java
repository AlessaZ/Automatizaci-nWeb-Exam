package com.nttdata.steps;

import com.nttdata.page.ShoppingCartPage;
import org.openqa.selenium.WebDriver;

public class ShoppingCartSteps {

    WebDriver driver;

    public ShoppingCartSteps(WebDriver driver) {
        this.driver = driver;
    }

    public double getPrice() {
        return Double.parseDouble(this.driver.findElement(ShoppingCartPage.price).getText().replaceAll("[^0-9.]", "").trim());
    }

    public double getTotalPrice() {
        return Double.parseDouble(this.driver.findElement(ShoppingCartPage.total).getText().replaceAll("[^0-9.]", "").trim());
    }

    public int getQuantity() {
        return Integer.parseInt(this.driver.findElement(ShoppingCartPage.quantity).getAttribute("value").trim());
    }

    public String getCartHeader() {
        return this.driver.findElement(ShoppingCartPage.headerCart).getText().trim();
    }

    public void clickBuyCartButton() {
        this.driver.findElement(ShoppingCartPage.buyCartButton).click();
    }

}
