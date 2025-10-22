package test;
 
import pages.LoginPage;
import pages.SearchUserPage;
import pages.AdminPage;
import pages.DeleteUserPage;
import pages.EditUserPage;
import base.ConfigReader;
import base.BaseTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
 
public class LoginTest extends BaseTest {
    @Test
    public void testCreateAdminUser() {
        String username = ConfigReader.readPropertyFileData("userName", "config");
        String password = ConfigReader.readPropertyFileData("password", "config");
        String empName = ConfigReader.readPropertyFileData("empName", "config");
        String newUserName = ConfigReader.readPropertyFileData("newUserName", "config");
        String newUserPassword = ConfigReader.readPropertyFileData("newUserPassword", "config");
        String newUserConfirmPassword = ConfigReader.readPropertyFileData("newUserConfirmPassword", "config");
        LoginPage loginPage = new LoginPage(page);
        loginPage.login(username, password);
        
        page.waitForSelector("text=Dashboard");
        AdminPage adminPage = new AdminPage(page);
        adminPage.openAdminSection();
        adminPage.clickAddButton();
        adminPage.fillUserDetails(empName, newUserName, newUserPassword, newUserConfirmPassword);
        adminPage.saveUser();
        page.waitForSelector("text=Successfully Saved");
        System.out.println("New admin user created successfully.");
 
        SearchUserPage searchUserPage = new SearchUserPage(page);
        String searchRole = ConfigReader.readPropertyFileData("searchRole", "config");
        String searchStatus = ConfigReader.readPropertyFileData("searchStatus", "config");
        searchUserPage.searchUser(newUserName, searchRole, searchStatus);
 
        EditUserPage editUserPage = new EditUserPage(page);
        String newStatus = ConfigReader.readPropertyFileData("newStatus", "config");
        editUserPage.editUserStatus(newUserName, newStatus);
 
        DeleteUserPage deleteUserPage = new DeleteUserPage(page);
        deleteUserPage.deleteUser();
        
    }}