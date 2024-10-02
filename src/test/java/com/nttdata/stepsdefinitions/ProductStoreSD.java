package com.nttdata.stepsdefinitions;

import com.nttdata.page.AddProductPage;
import com.nttdata.page.MyAccountPage;
import com.nttdata.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreSD {

    private WebDriver driver;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String pwd) {

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeEmail(email);
        loginSteps.typePassword(pwd);
        loginSteps.login();
        screenShot();

    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {

        NavigationSteps navigationSteps = new NavigationSteps(driver);
        String nameSpan = navigationSteps.getNameSpan();
        Assertions.assertEquals("Alessandra Morales", nameSpan);

        try {
            Assertions.assertEquals("Alessandra Morales", nameSpan);
            navigationSteps.clickCategoryByName(category);
            SubcategoriesListSteps subcategoriesListSteps = new SubcategoriesListSteps(driver);
            String subcategoryHeader = subcategoriesListSteps.getSubcategoryText();
            Assertions.assertEquals("Subcategorías", subcategoryHeader);
            subcategoriesListSteps.clickSubcategoryByName(subcategory);
            screenShot();

        } catch (AssertionError e) {
            System.out.println("Se ha encontrado el error: " + e.getMessage());
        }

    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {

        ItemCardsSteps itemCardsSteps = new ItemCardsSteps(driver);
        String title = itemCardsSteps.getTitle();

        try{

            Assertions.assertEquals("MEN", title);
            int sizeItems = itemCardsSteps.getItemSize();
            Assertions.assertTrue(sizeItems > 0, "El tamaño de la lista es: " + sizeItems);
            itemCardsSteps.clickPrimerElement();
            ProducSteps producSteps = new ProducSteps(driver);
            producSteps.typeQuantity(cantidad);
            producSteps.clickAddButton();
            screenShot();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {

        ProducSteps producSteps = new ProducSteps(driver);
        String headerText = producSteps.getHeaderText();
        System.out.println(headerText);

        try {
            Assertions.assertEquals("Producto añadido correctamente a su carrito de compra", headerText);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {

        ProducSteps producSteps = new ProducSteps(driver);
        double priceCalculated = producSteps.getPriceCalculated();
        double priceTotalCalculated = producSteps.getPriceTotalCalculated();
        int quantityCalculated = producSteps.getQuantityCalculated();

        try {
            double priceTotal = priceCalculated * quantityCalculated;
            Assertions.assertEquals(priceTotal, priceTotalCalculated);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {

        ProducSteps producSteps = new ProducSteps(driver);
        producSteps.clickBuyButton();
        screenShot();

    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {

        ShoppingCartSteps shoppingCartSteps = new ShoppingCartSteps(driver);
        String cartHeader = shoppingCartSteps.getCartHeader();

        try{
            Assertions.assertEquals("CARRITO", cartHeader);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {

        ShoppingCartSteps shoppingCartSteps = new ShoppingCartSteps(driver);
        double priceCalculated = shoppingCartSteps.getPrice();
        double priceTotalCalculated = shoppingCartSteps.getTotalPrice();
        int quantityCalculated = shoppingCartSteps.getQuantity();

        try{
            double priceTotal = priceCalculated * quantityCalculated;
            Assertions.assertEquals(priceTotal, priceTotalCalculated);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
