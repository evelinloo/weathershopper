package personal.weathershopper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class Helpers{
    WebDriver driver;

    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public void addCheapestInCategory(String category){
        List<WebElement> allDivs = driver.findElements(By.tagName("div"));
        int indexOfCheapest = 0;
        int cheapestInCategory = 9999;

        for (int i = 0; i < allDivs.size(); i++){
            String currentDiv = allDivs.get(i).getText();
            if (currentDiv.contains(category)){
                By priceLocator = RelativeLocator.with(By.tagName("p")).above(By.tagName("button"));

                // TODO: Find out how to use relative locators for price
                int price =
                if (price < cheapestInCategory) {
                    cheapestInCategory = price;
                    indexOfCheapest = i;
                }
            }
        }

        System.out.println(allDivs.get(indexOfCheapest).getText());
    }
}
