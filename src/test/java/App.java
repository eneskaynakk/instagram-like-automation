import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {

    WebDriver driver;
    String baseUrl = "https://www.instagram.com/accounts/login/?next=%2F&source=desktop_nav";

    public void application(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    private void explicitWait(String path){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(path)));

    }

    public void loginWith(String userName, String password){
        String userNamePath = "input[name=\"username\"]";
        explicitWait(userNamePath);
        String passwordPath = "input[name=\"password\"]";
        explicitWait(passwordPath);
        String loginButtonPath = "form#loginForm button[type=\"submit\"] > div";

        driver.findElement(By.cssSelector(userNamePath)).sendKeys(userName);
        driver.findElement(By.cssSelector(passwordPath)).sendKeys(password);
        driver.findElement(By.cssSelector(loginButtonPath)).click();

    }

    public void profileSearch(String profileName){
        String instagramLogoPath = "svg[aria-label=\"Instagram\"]";
        explicitWait(instagramLogoPath);
        driver.navigate().to("https://www.instagram.com/" + profileName + "/");

    }

    public void likeAllPost(){
        String postPath = "a[href=\"/reel/C9SeLUxs3lW/\"]";
        explicitWait(postPath);
        driver.findElement(By.cssSelector(postPath)).click();

        String postCountStr = driver.findElement(By.xpath("(//span[@class=\"_ac2a\"])[1]")).getText();
        int postCount = Integer.parseInt(postCountStr);

        for (int i=0; postCount>i; postCount--){
            String likeButtonPath = "span[class=\"x1rg5ohu xp7jhwk\"]";
            explicitWait(likeButtonPath);
            driver.findElement(By.cssSelector(likeButtonPath)).click();

            driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
        }

    }


}
