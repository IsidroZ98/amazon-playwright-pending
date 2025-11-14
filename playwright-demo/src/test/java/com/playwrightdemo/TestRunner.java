package com.playwrightdemo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class TestRunner {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;
    protected static APIRequestContext apiRequest;
    protected static BrowserContext browserContext;


    @BeforeAll
    static void setupBeforeClass(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        
        browserContext = browser.newContext(new Browser.NewContextOptions()
        .setUserAgent("playwright-java-test")
        .setExtraHTTPHeaders(Map.of("ngrok-skip-browser-warning", "true")
        ));
        //page = browser.newPage();
        page = browserContext.newPage();
        if(page.locator("text=Visit Site").isVisible()){
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Visit Site")).click();
            page.waitForLoadState();
        }
        apiRequest = playwright.request().newContext(new NewContextOptions().setBaseURL("https://4693ad88a1bd.ngrok-free.app"));
        if(page.locator("text=Visit Site").isVisible()){
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Visit Site")).click();
            page.waitForLoadState();
        }

    }
    @AfterAll
    public static void tearDownAfterClass(){
        page.close();
        browser.close();
        apiRequest.dispose();
        playwright.close();
        
    }
    

}