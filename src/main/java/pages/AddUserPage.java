package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddUserPage extends AbstractPage {

    public AddUserPage(WebDriver driver) {
        super(driver);
    }
    private By addBtn = By.xpath("//button[text()=' Add ']");
    private By userRoleDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");
    private By empNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private By usernameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By statusDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[2]");
    private By passwordInput = By.xpath("(//input[@type='password'])[1]");
    private By confirmPasswordInput = By.xpath("(//input[@type='password'])[2]");
    private By saveBtn = By.xpath("//button[@type='submit']");

    public void createUser(String role, String empName, String uname, String status, String password) {

        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();

        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + role + "']"))).click();

        By option = By.xpath("//div[@role='listbox']//span[text()='" + role + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(option)).click();


        WebElement empInput = wait.until(ExpectedConditions.visibilityOfElementLocated(empNameInput));
        empInput.sendKeys(empName);

        By suggestion = By.xpath("//div[@role='listbox']//span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestion)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys(uname);

        wait.until(ExpectedConditions.visibilityOfElementLocated(statusDropdown));
        driver.findElement(statusDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + status + "']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput));
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        driver.findElement(saveBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn));
    }
}
