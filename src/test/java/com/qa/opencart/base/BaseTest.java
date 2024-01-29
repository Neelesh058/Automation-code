package com.qa.opencart.base;

import co.qa.opencart.pages.HomePage;
import co.qa.opencart.pages.LoginPage;
import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected HomePage homepage;
    protected LoginPage loginpage;
    protected Properties prop;

    @BeforeTest
    public void setup() throws IOException {

        pf = new PlaywrightFactory();
        prop=pf.inti_prop();
        page = pf.intiBrowser(prop);
        homepage = new HomePage(page);
    }
//    @AfterTest
//    public void teardown()
//    {
//        page.context().browser().close();
//    }
}
