package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private String usernameField = "input[name='username']";
    private String passwordField = "input[name='password']";
    private String loginButton = "button[type='submit']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.locator(usernameField).fill(username);
        page.locator(passwordField).fill(password);
        page.locator(loginButton).click();
    }
}