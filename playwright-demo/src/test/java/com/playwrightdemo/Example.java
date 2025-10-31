package com.playwrightdemo;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
class testtest {
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    static Page page = browser.newPage();

    @BeforeAll
    static void setupBeforeClass()throws Exception{
        //page.navigate("https://ngrok-redirector.isidro-zapata.workers.dev");
        page.navigate("http://localhost:3000");
        System.out.println(page.url());
    }
    @AfterAll
    public static void tearDownAfterClass()throws Exception{
        page.close();

        playwright.close();

    }
    @Test
    void codegen_landingPageLinks() throws InterruptedException { 
        page.navigate("http://localhost:3000");
        Thread.sleep(3000);
        // Set before an action is being done that may take some time 
        //page.setDefaultTimeout(30000);
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About Me About Me Whoami,")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Projects Projects Linux,")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Experience Experience Resume")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("blog Blog Digital notebook of")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("[Home]")).click();
      page.setDefaultNavigationTimeout(3000);
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ascii image of resume Resume")).click();
      // can just switch to normal test not using a new page to click and go back on page, error no page to go back to 
      //page.goBack();
      page.setDefaultNavigationTimeout(3000);
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Linkedin")).click();
      //page.goBack();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Github")).click();
      //page.goBack();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Change Log")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Visit Site")).click();
    }

    

}
