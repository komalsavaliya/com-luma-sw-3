package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 5. Write down the following test into ‘MenTest’
 * class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Men Menu
 * * Mouse Hover on Bottoms
 * * Click on Pants
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on size
 * 32.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour
 * Black.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on
 * ‘Add To Cart’ Button.
 * * Verify the text
 * ‘You added Cronus Yoga Pant to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the text ‘Shopping Cart.’
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the product size ‘32’
 * * Verify the product colour ‘Black’
 */

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //* Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));
        Thread.sleep(2000);

        //* Mouse Hover on Bottoms
        mouseHoverToElement(By.id("ui-id-18"));
        Thread.sleep(2000);

        //* Click on Pants
        clickOnElement(By.id("ui-id-23"));
        Thread.sleep(2000);

      //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElementAndClick(By.xpath("//div[@id='option-label-size-143-item-175']"));
        Thread.sleep(2000);

        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElementAndClick(By.xpath("//div[@id='option-label-color-93-item-49']"));
        Thread.sleep(2000);

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElementAndClick(By.xpath("//button[contains(@title,'Add to Cart')]"));
        Thread.sleep(2000);

        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals("You added Cronus Yoga Pant to your shopping cart.", expectedText, actualText);
        Thread.sleep(2000);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Thread.sleep(2000);

        //* Verify the text ‘Shopping Cart.’
        String expectedText1 = "Shopping Cart";
        String actualText1 = getTextFromElement(By.xpath("//div[@class='page-title-wrapper']"));
        Assert.assertEquals("Shopping Cart", expectedText1, actualText1);
        Thread.sleep(2000);

        //* Verify the product name ‘Cronus Yoga Pant’
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Cronus Yoga Pant", expectedText2, actualText2);
        Thread.sleep(2000);

        //* Verify the product size ‘32’
        String expectedText3 = "32";
        String actualText3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("32", expectedText3, actualText3);
        Thread.sleep(2000);

        //* Verify the product colour ‘Black’
        String expectedText4 = "Black";
        String actualText4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Black", expectedText4, actualText4);
        Thread.sleep(2000);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}