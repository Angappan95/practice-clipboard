package ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;


public class Amazon {

    private static Logger logger = LoggerFactory.getLogger(Amazon.class);

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);

        logger.info("Navigate to Amazon website");
        driver.get("https://www.amazon.in");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

        WebElement eleHamburgerIcon = driver.findElement(By.id("nav-hamburger-menu"));
        eleHamburgerIcon.click();

        By xpathDepartment = By.xpath("//a[div[text()=\"TV, Appliances, Electronics\"]]");
        WebElement eleDepartment = driver.findElement(xpathDepartment);
        eleDepartment.click();

        WebElement eleTelevisonDepartment = driver.findElement(By.xpath("//a[text()=\"Televisions\"]"));
        eleTelevisonDepartment.click();

        By xpathSamsungTV = By.xpath("//div[div[span[text()=\"Brands\"]]]//a[span[text()=\"Samsung\"]]");
        WebElement eleSamsungCheckbox = driver.findElement(xpathSamsungTV);
        eleSamsungCheckbox.click();

        WebElement eleSortBtn = driver.findElement(By.cssSelector("[aria-label=\"Sort by:\"]"));
        actions.moveToElement(eleSortBtn).click().build().perform();

        WebElement elePriceHighToLow = driver.findElement(By.id("s-result-sort-select_2"));
        elePriceHighToLow.click();

        WebElement eleSecondItem = driver.findElement(By.cssSelector("[data-cel-widget=search_result_2]  a[class=\"a-link-normal s-no-outline\"]"));
        eleSecondItem.click();

        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>();
        windowsList.addAll(windows);
        driver.switchTo().window(windowsList.get(1));

        WebElement eleAboutItem = driver.findElement(By.cssSelector(("#feature-bullets > ul")));
        System.out.println(eleAboutItem.getText());

        logger.info("Close the chromedriver sessions");
        driver.quit();
    }

}
