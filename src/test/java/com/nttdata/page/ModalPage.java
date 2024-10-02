package com.nttdata.page;

import org.openqa.selenium.By;

public class ModalPage {

    public static By headerSuccess = By.id("myModalLabel");
    public static By buyButton = By.cssSelector("div.cart-content-btn a.btn.btn-primary");
    public static By quantityCalculated = By.id("productName");
    public static By priceCalculated = By.cssSelector("span.product-quantity strong");
    public static By priceTotalCalculated = By.cssSelector("p.product-total span.value");

}
