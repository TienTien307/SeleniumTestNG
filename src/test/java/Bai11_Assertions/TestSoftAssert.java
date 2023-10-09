package Bai11_Assertions;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssert extends BaseTest {
    @Test
    public void testSoftAssert(){
        driver.get("https://demo.activeitzone.com/ecommerce/login");

        String header = driver.findElement(By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(header, "Welcome to Active eCommerce CMS", "Header không đúng");

        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebElement menuProducts = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        softAssert.assertTrue(menuProducts.isDisplayed(), "Menu Products không hiển thị");

        menuProducts.click();

        driver.findElement(By.xpath("//span[normalize-space()='Add New product']")).click();
        WebElement headerAddNewProducts = driver.findElement(By.xpath("//h5[normalize-space()='Add New product']"));
        headerAddNewProducts.click();
        softAssert.assertTrue(headerAddNewProducts.isEnabled(),"Header addNewProducts không được bật");
        softAssert.assertEquals(headerAddNewProducts.getText(),"Selenium", "Content không match");

        // cuối cùng của softAssert là phải dùng hàm assertAll() để xác nhận các assert bên trên
        softAssert.assertAll();

    }
}
