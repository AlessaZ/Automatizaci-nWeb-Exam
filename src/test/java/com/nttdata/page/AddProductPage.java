package com.nttdata.page;

import org.openqa.selenium.By;

public class AddProductPage {

    public static By quantity = By.id("quantity_wanted");
    public static By addButton = By.cssSelector("div.add button.btn.btn-primary.add-to-cart");
    public static By priceTotalCalculated = By.cssSelector("p.product-total span.value");
    public static By headerSuccess = By.id("myModalLabel");
    public static By buyButton = By.cssSelector("div.cart-content-btn a.btn.btn-primary");
    public static By priceCalculated= By.cssSelector("p.product-price");
    public static By quantityCalculated = By.cssSelector("span.product-quantity strong");
    public static By modal = By.xpath("//*[@id=\"blockcart-modal\"]/div");

}