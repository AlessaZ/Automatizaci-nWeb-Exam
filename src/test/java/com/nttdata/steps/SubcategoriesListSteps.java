package com.nttdata.steps;

import com.nttdata.page.SubcategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubcategoriesListSteps {

    WebDriver driver;

    public SubcategoriesListSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSubcategoryByName(String subcategoryName) {
        List<WebElement> liItems = this.driver.findElements(SubcategoryPage.listSubcategories);

        for (WebElement item : liItems) {
            System.out.println(item);
            String nameElement = item.getAttribute("title");
            if (nameElement.equalsIgnoreCase(subcategoryName)) {
                item.click();
                System.out.println("Se hizo clic en la categoría: " + subcategoryName);
                break;
            }
        }
    }

    public String getSubcategoryText(){
        return this.driver.findElement(SubcategoryPage.subcategoriesHeader).getText().trim();
    }

}
