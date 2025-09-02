import org.testng.annotations.*;
import pages.*;
import static org.testng.Assert.*;

public class AddUserTest extends BaseTest {

    @Test
    public void testAddESSUser() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToAdminPage();

        AdminPage admin = new AdminPage(driver);
        admin.clickAddButton();

        AddUserPage addUser = new AddUserPage(driver);
        String username = "add_test_user" + System.currentTimeMillis();
        addUser.createUser("ESS", "S", username, "Enabled", "P@ssw0rd123");

        admin.searchUser(username);
        assertTrue(admin.isUserPresentAdd(), "New user should be listed after adding");
    }

    @Test
    public void testAddAdminUser() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToAdminPage();

        AdminPage admin = new AdminPage(driver);
        admin.clickAddButton();

        AddUserPage addUser = new AddUserPage(driver);
        String username = "add_test_user" + System.currentTimeMillis();
        addUser.createUser("Admin", "M", username, "Enabled", "P@ssw0rd123");

        admin.searchUser(username);
        assertTrue(admin.isUserPresentAdd(), "New user should be listed after adding");
    }

    @Test
    public void testAddDisabledStatusUser() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToAdminPage();

        AdminPage admin = new AdminPage(driver);
        admin.clickAddButton();

        AddUserPage addUser = new AddUserPage(driver);
        String username = "add_test_user" + System.currentTimeMillis();
        addUser.createUser("ESS", "L", username, "Disabled", "P@ssw0rd123");

        admin.searchUser(username);
        assertTrue(admin.isUserPresentAdd(), "New user should be listed after adding");
    }
}