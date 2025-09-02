package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends AbstractPage {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    private By addBtn = By.cssSelector("button.oxd-button--secondary");
    private By searchField = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By searchBtn = By.cssSelector("button[type='submit']");
    private By userRows = By.cssSelector(".oxd-table-body .oxd-table-row");
    private By deleteIcon = By.cssSelector(".oxd-icon.bi-trash");
    private By confirmDeleteBtn = By.cssSelector(".oxd-button--label-danger");

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn));
        driver.findElement(addBtn).click();
    }

    public void searchUser(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn));
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(username);
        driver.findElement(searchBtn).click();
    }

    public boolean isUserPresentAdd() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userRows));
        return !driver.findElements(userRows).isEmpty();
    }

    public boolean isUserPresentDelete() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(userRows));
        return !driver.findElements(userRows).isEmpty();
    }


    public void deleteUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteIcon));
        driver.findElement(deleteIcon).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteBtn));
        driver.findElement(confirmDeleteBtn).click();
    }
}
