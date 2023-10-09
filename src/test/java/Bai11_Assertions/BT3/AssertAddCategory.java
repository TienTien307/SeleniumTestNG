package Bai11_Assertions.BT3;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertAddCategory extends BaseTest {
    @Test(priority = 1)
    public void login() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 2)
    public void getText() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);

        //kiểm tra text trên trang
        String header = driver.findElement(By.xpath("//h1[normalize-space()='All categories']")).getText();
        SoftAssert allCategories = new SoftAssert();
        allCategories.assertEquals(header,"All categories 123", "Không đúng header");
//        allCategories.assertAll();


        String btn = driver.findElement(By.xpath("//a[@class='btn btn-primary']")).getText();
        SoftAssert btnAdd = new SoftAssert();
        btnAdd.assertEquals(btn, "Add New Category 123", "Không đúng text button");
//        btnAdd.assertAll();


        String theader = driver.findElement(By.xpath("//th[normalize-space()='Name']")).getText();
        System.out.println(theader);
        SoftAssert name = new SoftAssert();
        name.assertEquals(theader,"Name aa", "T_header không dúng");
        name.assertAll();

    }

    @Test (priority = 3)
    public void getTextdialog() throws InterruptedException {
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]/a[2]/i[1]")).click();




    }
//    @Test (priority = 3)
    public void Search() throws InterruptedException {
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("sp");
        search.submit();
        Thread.sleep(1000);

        WebElement name = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        String actual = name.getText();
        System.out.println(actual);

        String expected = "sp_1";

        //so sánh text
        if (actual.equals(expected)) {
            System.out.println("Văn bản chính xác: " + actual);
        } else {
            System.out.println("Văn bản không chính xác. Thực tế:  " + actual);
        }
    }
}
