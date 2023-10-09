package Bai11_Assertions;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHardAssert extends BaseTest {

    @Test(priority = 1)
    public void TestAssertEquals() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester Automation";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle, "Tiêu đề trang chưa đúng");
        System.out.println("Hard assertion");
    }

    @Test(priority = 2)
    public void TestAssertTrue() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester 123";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertTrue(actualTitle.contains("Anh Tester 123"), "tiêu đề không chứa " +expectedTitle);
        System.out.println("làm gì đó ...");
    }

}
