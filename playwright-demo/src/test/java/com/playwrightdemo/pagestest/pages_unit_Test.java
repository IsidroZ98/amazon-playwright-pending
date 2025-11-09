package com.playwrightdemo.pagestest;

import com.playwrightdemo.TestRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.microsoft.playwright.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals; 
public class pages_unit_Test extends TestRunner{
    
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    static Page page = browser.newPage();
    static String homePage = "http://localhost:3000";
    static String aboutmePage = "http://localhost:3000/about";
    static String projectsPage = "http://localhost:3000/projects";
    static String experiencePage = "http://localhost:3000/experience";
    static String blogPage = "http://localhost:3000/blog";
    /*
     * Home page
     */
    @Test
    @DisplayName("Home => Home Page should show correct title")
    public void homePage_test(){
        page.navigate(homePage);
        assertEquals("Izzy's Blog-Portfolio", page.title(), "Page title should match expected");
    }
    @Test
    @DisplayName("Home => Change log should be present")
    public void homePage_changeLogTest(){
        page.navigate(homePage);
        assertTrue(page.content().contains("Change Log"), "Home page should have Change Log present");
    }
    /*
     * About Me page 
     */
    @Test
    @DisplayName("About Me => About me should show correct title")
    public void aboutMePage_titleTest(){
        page.navigate(aboutmePage);
        assertEquals("About me!", page.title(), "Page title should read About me");
    }
    @Test
    @DisplayName("About Me => whoami => Whoami section should appear in about me page")
    public void aboutMePage_whoamiTest(){
        page.navigate(aboutmePage);
        assertTrue(page.content().contains("Whoami:"), "Whoami section card should be present");  
    }
    @Test
    @DisplayName("About Me => Journey => Journey section should appear in about me page")
    public void aboutMePage_journeyTest(){
        page.navigate(aboutmePage);
        assertTrue(page.content().contains("Journey:"), "journey section card should be present");
    }
    @Test
    @DisplayName("About Me => quick,facts,misc => Misc section should appear in about me page")
    public void aboutMePage_miscTest(){
        page.navigate(aboutmePage);
        assertTrue(page.content().contains("Quick, important facts, misc:"), "facts and misc section card should be present");
    }
    /*
     * Project Page]
     */
    @Test
    @DisplayName("Projects => Projects page should show correct title")
    public void project_titleTest(){
        page.navigate(projectsPage);
        assertEquals(("Projects!"), page.title(), "Page title should read Projects!");
    }
    @Test
    @DisplayName("Projects => Project card portfolio title should appear correct")
    public void project_PortfolioCardTest(){
        page.navigate(projectsPage);
        Locator portfolioProjectHead = page.locator("id=portfolio-header");
        Locator portfolioProjectParagraph = page.locator("id=portfolio-para");
        assertEquals(("Portfolio Website"), portfolioProjectHead.textContent(),"Portfolio website card should be present");
        assertTrue(portfolioProjectParagraph.textContent().contains("A multi-page personal website build"),"Project desc should read multi page personal website");
    }
    @Test
    @DisplayName("Projects => Project card playwright title should appear correct")
    public void project_playwrightBlogfolioCardTest(){
        page.navigate(projectsPage);
        Locator portfolioProjectHead = page.locator("id=pb-header");
        Locator portfolioProjectParagraph = page.locator("id=pb-para");
        assertEquals(("Playwright testing blogFolio"), portfolioProjectHead.textContent(),"Playwright testing this site card should be present");
        assertTrue(portfolioProjectParagraph.textContent().contains("Using Playwright in Java to test this website"),"Project desc should read playwright in java");
    }
    @Test
    @DisplayName("Projects => Project card Automation Planeterium title should appear correct")
    public void project_planetCardTest(){
        page.navigate(projectsPage);
        Locator portfolioProjectHead = page.locator("id=planet-header");
        Locator portfolioProjectParagraph = page.locator("id=planet-para");
        assertEquals(("Automation Planeterium Testing Suite"), portfolioProjectHead.textContent(),"Selenium and TestNG project card should be present");
        assertTrue(portfolioProjectParagraph.textContent().contains("A Selenium and TestNG project"),"Project desc should read playwright in java");
    }
    @Test
    @DisplayName("Projects => Project card rtl title should appear correct")
    public void project_rtlCardTest(){
        page.navigate(projectsPage);
        Locator portfolioProjectHead = page.locator("id=rtl-header");
        Locator portfolioProjectParagraph = page.locator("id=rtl-para");
        assertEquals(("rtl88 arch linux drivers"),portfolioProjectHead.textContent(),"rtl88 archlinux project card should be present");
        assertTrue(portfolioProjectParagraph.textContent().contains("Script to install driver on Manjaro"),"Project desc should read script for arch linux and manjaro");
    }
    @Test
    @DisplayName("Projects => Project card amazonSelenium title should appear correct")
    public void project_amazonSelCardTest(){
        page.navigate(projectsPage);
        Locator portfolioProjectHead = page.locator("id=amazonSel-header");
        Locator portfolioProjectParagraph = page.locator("id=amazonSel-para");
        assertEquals(("Amazon-Selenium"),portfolioProjectHead.textContent(),"Amazon Selenium project card should be present");
        assertTrue(portfolioProjectParagraph.textContent().contains("Simple Amazon Selenium project"),"Project desc should read Simple Amazon Selenium project");
    }
    @Test
    @DisplayName("Projects => Project card SnapinstaTool title should appear correct")
    public void project_snapinstaToolCardTest(){
        page.navigate(projectsPage);
        Locator portfolioProjectHead = page.locator("id=snapinstaTool-header");
        Locator portfolioProjectParagraph = page.locator("id=snapinstaTool-para");
        assertEquals(("insta-snapinsta-download-tool"),portfolioProjectHead.textContent(),"Instagram snapinsta tool project card should be present");
        assertTrue(portfolioProjectParagraph.textContent().contains("Instagram stole my idea"),"Project desc should read this was my personal solution to downloading");
    }
    /*
     * TODO: Add project link verification
     */
}
