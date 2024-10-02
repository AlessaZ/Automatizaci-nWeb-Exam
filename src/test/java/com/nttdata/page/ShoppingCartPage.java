package com.nttdata.page;

import org.openqa.selenium.By;

public class ShoppingCartPage {

    public static By headerCart = By.cssSelector("div.card-block h1.h1");
    public static By quantity = By.className("product-quantity-spin");
    public static By price = By.cssSelector("div.current-price span.price");
    public static By total = By.cssSelector("div.cart-summary-line.cart-total span.value");
    public static By buyCartButton = By.cssSelector("div.text-sm-center a.btn.btn-primary");

}
