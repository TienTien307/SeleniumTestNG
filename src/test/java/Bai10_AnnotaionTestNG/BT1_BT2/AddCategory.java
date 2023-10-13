package Bai10_AnnotaionTestNG.BT1_BT2;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;

public class AddCategory extends BaseTest {

    @Test(priority = 1)
    public void login() throws InterruptedException {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void AddCategory() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
//        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("sp_2");
//        Select parent = new Select(driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select2 form-control aiz-']//select")));
//        parent.selectByVisibleText("Demo category 1");
//        driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[2]")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("cp");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@title='cp_2.jpg']//img[@class='img-fit']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("tiennt");
//        Select atrribute = new Select(driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div/div/select")));
//        atrribute.selectByIndex(1);
//        Thread.sleep(1000);

        inputForm("sp1", "01", "meta title", "description", "cp");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    @Test(priority = 3)
    public void Search() throws InterruptedException {
        Thread.sleep(1000);
//        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
//        search.sendKeys("sp");
//        search.submit();
        Thread.sleep(1000);
        inputSearch("sp-1");

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

    @Test(priority = 4)
    public void EditCategory() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]/a[1]/i[1]")).click();
        inputForm("đã edit name");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        Thread.sleep(1000);

        inputSearch("sp");
        Thread.sleep(1000);
    }

//    @Test (priority = 5)
//    public void DeleteCategory() throws InterruptedException {
//        driver.findElement(By.xpath("//table//tr[1]//td[10]/a[2]")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//a[@id='delete-link']")).click();
//        Thread.sleep(1000);
//        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
//        search.sendKeys("sp");
//        search.submit();
//        Thread.sleep(1000);
//    }

    @Test
    public void AddNewProduct() throws InterruptedException{
        backtohome();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New Product']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='category']//label[@class='col-md-3 col-from-label']//following-sibling::div/div")).click();
        Thread.sleep(500);
        WebElement category = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));
        category.sendKeys("sp1");
        category.submit();

        driver.findElement(By.xpath("//div[@class='col-md-1']//span")).click();
        Thread.sleep(500);
        WebElement select = driver.findElement(By.xpath("div[class='dropdown bootstrap-select show-tick form-control aiz-'] button[title='Nothing selected']"));
        select.click();

        WebElement searchColor = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']"));

        Actions action = new Actions(driver);
        //nhập value 1
        action.sendKeys(searchColor,"Azuze").sendKeys(Keys.ENTER).build().perform();
        // bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        action.keyDown(Keys.BACK_SPACE).build().perform();
        //nhập value 2
        action.sendKeys(searchColor,"black").sendKeys(Keys.ENTER).build().perform();

        //check select


    }

    public void backtohome(){
        driver.findElement(By.xpath("//img[@alt='Active eCommerce CMS']")).click();
    }

    public void inputForm(String name, String orderingNumber, String metaTitle, String description, String searchImg) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        Select parent = new Select(driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select select2 form-control aiz-']//select")));
        parent.selectByVisibleText("Demo category 1");

        if (searchImg != "") {
            driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(searchImg);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@title='cp_2.jpg']//img[@class='img-fit']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys(metaTitle);
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys(description);
    }

    public void inputForm(String name) throws InterruptedException {
        inputForm(name, "", "", "", "");
    }

    public void inputSearch(String search) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(search);
        driver.findElement(By.xpath("//input[@id='search']")).submit();
        Thread.sleep(1000);
    }
}
