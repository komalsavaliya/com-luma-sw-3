package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 6.Write down the following test into ‘GearTest’ class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Gear Menu
 * * Click on Bags
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change Qty 3
 * * Click on ‘Add to Cart’ Button.
 * * Verify the text
 */
public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        //* Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
        Thread.sleep(2000);

        //* Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        Thread.sleep(2000);

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        Thread.sleep(2000);

        //* Verify the text ‘Overnight Duffle’
        String expectedText5 = "Overnight Duffle";
        String actualText5 = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Overnight Duffle", expectedText5, actualText5);
        Thread.sleep(2000);


        //* Change Qty 3
        toClear(By.xpath("//input[@id='qty']"));
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        Thread.sleep(2000);

        //* Click on ‘Add to Cart’Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText6 = "You added Overnight Duffle to your shopping cart.";
        String actualText6 = getTextFromElement(By.xpath("//div [@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("You added Overnight Duffle to your shopping cart.", expectedText6, actualText6);
        Thread.sleep(2000);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[@class='action showcart']"));
        Thread.sleep(2000);

        //* Verify the product name ‘Overnight Duffle’
        String expectedText7 = "Overnight Duffle";
        String actualText7 = getTextFromElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        Assert.assertEquals("Overnight Duffle", expectedText7, actualText7);
        Thread.sleep(2000);

        //* Verify the Qty is ‘3’
        String expectedText8 = "3";
        String actualText8 = getTextFromElement(By.xpath(("//span[@class='counter-number']")));
        Assert.assertEquals("3", expectedText8, actualText8);
        Thread.sleep(2000);

        //* Verify the product price ‘$135.00’
        String expectedText9 = "$135.00";
        String actualText9 = getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
        //String actualText9 = getTextFromElement(By.xpath("/span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        Assert.assertEquals("$135.00", expectedText9, actualText9);
        Thread.sleep(2000);

        //View and edit Cart
        clickOnElement(By.xpath("//a[@class='action viewcart']"));

        //* Change Qty to ‘5’
        toClear(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input"));
        //toClear(By.xpath("//body[@class-'catalog-product-view product-overnight-duffle page-layout-1column']"));
        // toClear(By.xpath("//input[@id='cart-237972-qty']"));
        //toClear(By.xpath("//input[@id='cart-item-488793-qty']"));

        Thread.sleep(2000);
        sendTextToElement(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input"), "5");
        Thread.sleep(2000);


        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        //* Verify the product price ‘$225.00’
//        String expectedText10 = "$225.00";
//        String actualText10 = getTextFromElement(By.xpath("//td[@data-th='Subtotal']//span[@class='price']"));
//        Assert.assertEquals("$225.00", expectedText10, actualText10);
//        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
