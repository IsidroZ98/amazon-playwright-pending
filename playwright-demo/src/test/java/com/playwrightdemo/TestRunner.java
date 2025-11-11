package com.playwrightdemo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.APIRequest.NewContextOptions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
public class TestRunner {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;
    protected static APIRequestContext apiRequest;
    

    @BeforeAll
    static void setupBeforeClass(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        apiRequest = playwright.request().newContext(new NewContextOptions().setBaseURL("http://localhost:3000"));
    }
    @AfterAll
    public static void tearDownAfterClass(){
        page.close();
        browser.close();
        apiRequest.dispose();
        playwright.close();
        
    }

}
