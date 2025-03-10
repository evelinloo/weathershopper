import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class MoisturizerOrSunscreen {
    public static WebDriver driver = new ChromeDriver();

    // Learning TestNG here
    @BeforeSuite
    public static void setUp(String[] args) {
        driver.get("https://weathershopper.pythonanywhere.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test
    public void moisturizerOrSunscreen(){
        WebElement temperatureElement = driver.findElement(By.id("temperature"));
        int temperature = Integer.parseInt(temperatureElement.getText().substring(0,2).trim());

        WebElement buyMoisturizers = driver.findElement(By.linkText("Buy moisturizers"));
        WebElement buySunscreens = driver.findElement(By.linkText("Buy sunscreens"));

        if (temperature < 19) buyMoisturizers.click();
        if (temperature > 35) buySunscreens.click();
    }

    @AfterSuite
    public static void tearDown(){
        driver.quit();
    }
}