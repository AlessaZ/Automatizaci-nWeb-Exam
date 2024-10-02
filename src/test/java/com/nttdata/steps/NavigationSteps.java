package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NavigationSteps {

    private WebDriver driver;

    public NavigationSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCategoryByName(String categoryName) {
        List<WebElement> categories = driver.findElements(MyAccountPage.categoriesMenu);
        for (WebElement category : categories) {
            String name = category.findElement(By.tagName("a")).getText().trim();
            if (name.equalsIgnoreCase(categoryName)) {
                category.click();
                break;
            }
        }
    }


    public String getNameSpan(){
        return driver.findElement(MyAccountPage.nameValidation).getText().trim();

    }

}
