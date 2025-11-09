package com.playwrightdemo;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
public class TestRunner {
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    static Page page = browser.newPage();

    @BeforeAll
    static void setupBeforeClass()throws Exception{page.navigate("http://localhost:3000");System.out.println(page.url());}
    @AfterAll
    public static void tearDownAfterClass()throws Exception{page.close();browser.close();playwright.close();}

}
