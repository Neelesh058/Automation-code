package com.qa.opencart.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PlaywrightFactory
{
    Playwright playwright;
    Browser browser = null;
    BrowserContext browserContext;
    Page page;
    Properties prop;
    public Page intiBrowser(Properties prop){

       String browserName= prop.getProperty("browser").trim();
        System.out.println("Browesr name is"+browserName);
        playwright=Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser= playwright.firefox().launch(new LaunchOptions().setHeadless(false));
                break ;
            case "safari":
                browser= playwright.webkit().launch(new LaunchOptions().setHeadless(false));
                break ;
            case "chrome":
                browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                break ;
            default:
                System.out.println("please enter rght browesr name");
                break;
        }
        browserContext=browser.newContext();
        page=browserContext.newPage();
        page.navigate(prop.getProperty("url").trim());
        return page;
    }
    public Properties inti_prop()  {
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/Configure/config.properties");
            prop=new Properties();
            prop.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
    public static String takeScreenShot(){

        String path=System.getProperty("user.dir")+"/screenshot/"+ System.currentTimeMillis()+".png";
        getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));

                return path;
    }

    private static Page getPage() {
        return null;
    }
}
