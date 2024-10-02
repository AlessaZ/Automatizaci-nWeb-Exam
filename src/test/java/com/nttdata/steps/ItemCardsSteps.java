package com.nttdata.steps;

import com.nttdata.page.CategorySubcategoryPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ItemCardsSteps {

    WebDriver driver;

    public ItemCardsSteps(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar hasta que el elemento se encuentre
        WebElement menTitleElement = wait.until(ExpectedConditions.presenceOfElementLocated(CategorySubcategoryPage.menTitle));
        return menTitleElement.getText().trim();
    }

    public int getItemSize(){
        List<WebElement> items = this.driver.findElements(CategorySubcategoryPage.itemsCards);
        return items.size();
    }

    public void clickPrimerElement(){
        this.driver.findElements(CategorySubcategoryPage.itemsCards).get(0).click();
    }
}
