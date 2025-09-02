package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public void login(String user, String pass) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));

        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
    }
}
