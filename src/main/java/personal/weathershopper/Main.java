package personal.weathershopper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Helpers helpers = new Helpers(driver);

        // Setup
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Decide whether to buy moisturizer or sunscreen
        WebElement temperatureElement = driver.findElement(By.id("temperature"));
        int temperature = Integer.parseInt(temperatureElement.getText().substring(0,2).trim());

        WebElement buyMoisturizersBtn = driver.findElement(By.linkText("Buy moisturizers"));
        WebElement buySunscreensBtn = driver.findElement(By.linkText("Buy sunscreens"));

        if (temperature < 19) buyMoisturizersBtn.click();
        if (temperature > 35) buySunscreensBtn.click();

        // Choose cheapest sunscreen for SPF-50 and SPF-30 OR get cheapest moisturizer containing aloe or almond
        String url = driver.getCurrentUrl();
        if (url.equals("https://weathershopper.pythonanywhere.com/sunscreen")) {
            helpers.addCheapestInCategory("spf-50");
            helpers.addCheapestInCategory("spf-30");
        } else if (url.equals("https://weathershopper.pythonanywhere.com/moisturizer")) {
            helpers.addCheapestInCategory("aloe");
            helpers.addCheapestInCategory("almond");
        }

        // Tear down
        driver.quit();
    }
}

