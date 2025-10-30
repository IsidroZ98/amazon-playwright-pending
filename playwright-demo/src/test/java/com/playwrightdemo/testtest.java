package com.playwrightdemo;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
class testtest {
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    static Page page = browser.newPage();

    @BeforeAll
    static void setupBeforeClass()throws Exception{
        page.navigate("https://google.com");
        System.out.println(page.url());
    }
    @AfterAll
    public static void tearDownAfterClass()throws Exception{
        page.close();

        playwright.close();

    }
    @Test
    void testApp(){
        page.reload();    }

}
