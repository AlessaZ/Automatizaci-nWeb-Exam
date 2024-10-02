package com.nttdata.page;

import org.openqa.selenium.By;

public class SubcategoryPage {

    public static By subcategoriesHeader = By.cssSelector("div.card.card-block h2.subcategory-heading");
    public static By listSubcategories = By.cssSelector("ul.subcategories-list li div.subcategory-image a");
}
