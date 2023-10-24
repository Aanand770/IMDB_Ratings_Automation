package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IMDB_Ratings_Automation {
    ChromeDriver driver;

    public IMDB_Ratings_Automation(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void  testCase01(){
//        Navigate to URL  https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
//        Get the highest rated movie Using Locator "XPath" //div[@data-testid="chart-layout-main-column"]/ul/li/div[@class="ipc-metadata-list-summary-item__c"]/div/div/div/a/h3 | gettext()
        System.out.println("Highest Rated Movie is : " + driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li/div[@class=\"ipc-metadata-list-summary-item__c\"]/div/div/div/a/h3")).getText());
//        Get no. of movies included on the table Using Locator "XPath" //div[@data-testid="chart-layout-main-column"]/ul/li | size()
        List <WebElement> MoviesCount = driver.findElements(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li"));
        System.out.println("No. of movies included on the table : " + MoviesCount.size());
//        Retrive oldest movie Using Locator "XPath" //div[@data-testid="chart-layout-main-column"]/ul/li/div[@class="ipc-metadata-list-summary-item__c"]/div/div/div[contains(@class, 'cli-title-metadata')]/span[1] | iteratrate through the list and get the print the oldest movie
        WebElement SortByDropdown = driver.findElement(By.id("sort-by-selector"));
        SortByDropdown.click();
        driver.findElement(By.xpath("//option[text() = 'Release date']")).click();
        driver.findElement(By.id("swap-sort-order-button")).click();
        System.out.println("Oldest Movie Year is : " + driver.findElement(By.xpath("(//div[@data-testid=\"chart-layout-main-column\"]/ul/li/div[@class=\"ipc-metadata-list-summary-item__c\"]/div/div/div[contains(@class, 'cli-title-metadata')]/span[1])[1]")).getText());
//        Retrive recent movie Using Locator "XPath" //div[@data-testid="chart-layout-main-column"]/ul/li/div[@class="ipc-metadata-list-summary-item__c"]/div/div/div[contains(@class, 'cli-title-metadata')]/span[1] | iteratrate through the list and get the print the recent movie
        SortByDropdown.click();
        driver.findElement(By.xpath("//option[text() = 'Release date']")).click();
        driver.findElement(By.id("swap-sort-order-button")).click();
        System.out.println("Recent Movie Year is : " + driver.findElement(By.xpath("(//div[@data-testid=\"chart-layout-main-column\"]/ul/li/div[@class=\"ipc-metadata-list-summary-item__c\"]/div/div/div[contains(@class, 'cli-title-metadata')]/span[1])[1]")).getText());
//        Get the more user rating Using Locator "XPath" //div[@data-testid="ratingGroup--container"]/span | gettext()
        List <WebElement> Ratings = driver.findElements(By.xpath("//div[@data-testid=\"ratingGroup--container\"]/span"));
        for (WebElement rating : Ratings){
            System.out.println("Get the User Ratings : " + rating.getText());
        }
    }
}