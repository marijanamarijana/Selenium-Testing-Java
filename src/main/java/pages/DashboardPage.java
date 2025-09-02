package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends AbstractPage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    private By adminTab = By.xpath("//span[text()='Admin']");

    public void goToAdminPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminTab));
        driver.findElement(adminTab).click();
    }
}
