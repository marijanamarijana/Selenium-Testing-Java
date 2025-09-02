import org.testng.annotations.*;
import pages.*;
import static org.testng.Assert.*;

public class DeleteUserTest extends BaseTest {

    @Test
    public void testDeleteESSUser() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToAdminPage();

        AdminPage admin = new AdminPage(driver);
        String userToDelete = "delete_test_user" + System.currentTimeMillis();

        admin.clickAddButton();
        AddUserPage addUser = new AddUserPage(driver);
        addUser.createUser("ESS", "S", userToDelete, "Enabled", "P@ssw0rd123");

        admin.searchUser(userToDelete);
        if (admin.isUserPresentDelete()) {
            admin.deleteUser();
        }

        admin.searchUser(userToDelete);
        assertFalse(admin.isUserPresentDelete(), "User should no longer be listed after deletion");
    }

    @Test
    public void testDeleteAdminUser() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToAdminPage();

        AdminPage admin = new AdminPage(driver);
        String userToDelete = "delete_test_user" + System.currentTimeMillis();

        admin.clickAddButton();
        AddUserPage addUser = new AddUserPage(driver);
        addUser.createUser("Admin", "l", userToDelete, "Enabled", "P@ssw0rd123");

        admin.searchUser(userToDelete);
        if (admin.isUserPresentDelete()) {
            admin.deleteUser();
        }

        admin.searchUser(userToDelete);
        assertFalse(admin.isUserPresentDelete(), "User should no longer be listed after deletion");
    }

    @Test
    public void testDeleteDisabledStatusUser() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToAdminPage();

        AdminPage admin = new AdminPage(driver);
        String userToDelete = "delete_test_user" + System.currentTimeMillis();

        admin.clickAddButton();
        AddUserPage addUser = new AddUserPage(driver);
        addUser.createUser("ESS", "M", userToDelete, "Disabled", "P@ssw0rd123");

        admin.searchUser(userToDelete);
        if (admin.isUserPresentDelete()) {
            admin.deleteUser();
        }

        admin.searchUser(userToDelete);
        assertFalse(admin.isUserPresentDelete(), "User should no longer be listed after deletion");
    }
}
