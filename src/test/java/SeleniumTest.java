import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("AppendingElements.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }

    @Test
    public void addOneItemTest() {
        // find input element:
        WebElement input = driver.findElement(By.id("input"));

        // type in input box:
        input.sendKeys("apples");

        // find submit button and submit:
        WebElement button = driver.findElement(By.id("button"));
        button.click();

        // find list of items and ensure item is there:
        List<WebElement> list = driver.findElements(By.cssSelector("#list li"));

        Assert.assertEquals(1, list.size());

        Assert.assertEquals("apples", list.get(0).getText());
    }

    @Test
    public void addThreeItemsTest() {
        // find input element:
        WebElement input = driver.findElement(By.id("input"));

        // type in input box:
        input.sendKeys("apples");

        // find submit button and submit:
        WebElement button = driver.findElement(By.id("button"));
        button.click();

        // send more items:
        input.clear();
        input.sendKeys("bananas");
        button.click();
        input.clear();
        input.sendKeys("oranges");
        button.click();

        // find list of items and ensure items are there:
        List<WebElement> list = driver.findElements(By.cssSelector("#list li"));

        Assert.assertEquals(3, list.size());

        Assert.assertEquals("apples", list.get(0).getText());
        Assert.assertEquals("bananas", list.get(1).getText());
        Assert.assertEquals("oranges", list.get(2).getText());
    }

    @Test
    public void emptyListTest() {
        // find input element:
        WebElement input = driver.findElement(By.id("input"));

        // find list of items and ensure no items:
        List<WebElement> list = driver.findElements(By.cssSelector("#list li"));

        Assert.assertEquals(0, list.size());

    }


    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}