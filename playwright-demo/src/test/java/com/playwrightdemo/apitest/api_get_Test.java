package com.playwrightdemo.apitest;

import com.playwrightdemo.TestRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.microsoft.playwright.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class api_get_Test extends TestRunner{
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    static Page page = browser.newPage();
    static APIRequestContext apiRequest;
    String homePage = "http://localhost:3000";

    @Test
    @DisplayName("API => GET, 404 error route ")
    void getErrorRoute(){
        APIResponse response = page.request().get(homePage + "/error");
        assertEquals(404, response.status());
        assertTrue(response.text().contains("Page Not Found"),"Page should report the route does not exist");
        System.out.println("GET /ERROR => " + response.status());
    }
    @Test
    @DisplayName("API => GET, 200 home page route ")
    void getHomeRoute(){
        APIResponse response = page.request().get(homePage + "/");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("Welcome"),"Body should contain Welcome text");
        System.out.println("GET / => " + response.status());
    }
    @Test
    @DisplayName("API => GET, 200 About me route ")
    void getAboutRoute(){
        APIResponse response = page.request().get(homePage + "/about");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("About me!"),"Body should contain About me! text");
        System.out.println("GET /about => " + response.status());
    }
    @Test
    void getProjectsRoute(){
        APIResponse response = page.request().get(homePage + "/projects");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("Projects"),"Body should contain Projects text");
        System.out.println("GET /projects => " + response.status());
    }
    @Test
    void getExperienceRoute(){
        APIResponse response = page.request().get(homePage + "/experience");
        assertEquals(200,response.status());
        assertTrue(response.text().contains("experience"),"Body should contain Experience text");
        System.out.println("GET /experience => " + response.status());
    }
    @Test
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
    void getResumeRoute(){
        APIResponse response = page.request().get(homePage + "/documents/Isidro-Zapata-Resume.pdf");
        assertEquals(200,response.status());
        
        assertEquals("application/pdf", response.headers().get("content-type"));

    }
}
