package com.playwrightdemo.apitest;

import com.playwrightdemo.TestRunner;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.microsoft.playwright.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class api_get_Test extends TestRunner{
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    //static Page page = browser.newPage();
    static APIRequestContext apiRequest;
    static BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
        .setUserAgent("playwright-java-test")
        .setExtraHTTPHeaders(Map.of("ngrok-skip-browser-warning", "true")
        ));
    String homePage = "https://4693ad88a1bd.ngrok-free.app";

    @Test
    @DisplayName("API => GET, 404 error route ")
    @AllureId("Test-Case-1")
    @Description("API ")
    void getErrorRoute(){
        APIResponse response = page.request().get(homePage + "/error");
        assertEquals(404, response.status());
        assertTrue(response.text().contains("Page Not Found"),"Page should report the route does not exist");
        System.out.println("GET /ERROR => " + response.status());
    }
    @Test
    @DisplayName("API => GET, 200 home page route ")
    @AllureId("Test-Case-2")
    @Description("API ")
    void getHomeRoute(){
        APIResponse response = page.request().get(homePage + "/");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("Welcome"),"Body should contain Welcome text");
        System.out.println("GET / => " + response.status());
    }
    @Test
    @DisplayName("API => GET, 200 About me route")
    @AllureId("Test-Case-3")
    @Description("API ")
    void getAboutRoute(){
        APIResponse response = page.request().get(homePage + "/about");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("About me!"),"Body should contain About me! text");
        System.out.println("GET /about => " + response.status());
    }
    @Test
    @DisplayName("API => GET,200 Projects route")
    @AllureId("Test-Case-4")
    @Description("API ")
    void getProjectsRoute(){
        APIResponse response = page.request().get(homePage + "/projects");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("Projects"),"Body should contain Projects text");
        System.out.println("GET /projects => " + response.status());
    }
    @Test
    @DisplayName("API => GET,200 Experience route")
    @AllureId("Test-Case-5")
    @Description("API ")
    void getExperienceRoute(){
        APIResponse response = page.request().get(homePage + "/experience");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("experience"),"Body should contain Experience text");
        System.out.println("GET /experience => " + response.status());
    }
    @Test
    @DisplayName("API => GET, 200 Blog route")
    @AllureId("Test-Case-6")
    @Description("API ")
    void getBlogRoute(){
        APIResponse response = page.request().get(homePage + "/blog");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("blog"),"Body should contain Blog text");
        System.out.println("GET /blog => " + response.status());
    }
    /*
     * File endpoints
     */
    @Test
    @DisplayName("API => GET, 200 => Resume file")
    @AllureId("Test-Case-7")
    @Description("API ")
    void getResumeRoute(){
        APIResponse response = page.request().get(homePage + "/documents/Isidro-Zapata-Resume.pdf");
        assertEquals(200,response.status());
        
        assertEquals("application/pdf", response.headers().get("content-type"));

    }
}
