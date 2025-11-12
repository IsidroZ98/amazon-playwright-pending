package com.playwrightdemo.smoketest;
import com.microsoft.playwright.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.options.*;
import com.playwrightdemo.TestRunner;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;

public class codegen_blogUI_Test extends TestRunner{
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    static Page page = browser.newPage();
    // Smoke test local and +1 ping to ngrok limiter
    @Test
    @DisplayName("Codegen generated test with fall back to home page smoke test")
    @AllureId("Test-Case-21")
    @Description("Assert all pages all present ")
    void codegen_landingPageLinks() throws InterruptedException{
        page.navigate("http://localhost:3000");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About Me About Me Whoami,")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Projects Projects Linux,")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Experience Experience Resume")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("blog Blog Digital notebook of")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ascii image of resume Resume")).click();
        page.navigate("http://localhost:3000");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Linkedin")).click();
        page.navigate("http://localhost:3000");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Github")).click();
        page.navigate("http://localhost:3000");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Change Log")).click();
        // Visit Site from accepting link from Ngrok ping +1 rate limit
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Visit Site")).click();
    }
}
