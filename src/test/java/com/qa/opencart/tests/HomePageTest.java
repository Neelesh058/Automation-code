package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constant.AppConstant;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest(){
      String actualTile=homepage.getHomePageTitle();
        Assert.assertEquals(actualTile, AppConstant.HOME_PAGE_TITLE);//query
    }
    @Test
    public void homePageurlTest(){
        String actualUrl=homepage.HomePageUrl();
        Assert.assertEquals(actualUrl,prop.getProperty("url"));
    }

    @DataProvider
    public Object[][] getProviderData(){
        return new Object[][]{
            {"Macbook"},
            {"iMac"},
            {"Samsung"}
        };
    }
    @Test(dataProvider="getProviderData")
    public void searchTest(String productName){
        String searchHeader=homepage.doSearch(productName);
        Assert.assertEquals(searchHeader,"Search - "+productName);
    }



}
