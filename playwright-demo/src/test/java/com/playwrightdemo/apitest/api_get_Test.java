package com.playwrightdemo.apitest;

import com.playwrightdemo.TestRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import com.microsoft.playwright.*;
import com.microsoft.playwright.APIRequest.NewContextOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class api_get_Test extends TestRunner{
    static Playwright playwright;
    static APIRequestContext apiRequest;
    
    @BeforeAll
    static void setUp(){
        playwright = Playwright.create();
        apiRequest = playwright.request().newContext(new NewContextOptions().setBaseURL("http://localhost:3000"));
    }
    @AfterAll
    static void tearDown(){
        apiRequest.dispose();
        playwright.close();
    }
    // TODO: Tomorrow API test
}
