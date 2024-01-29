package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constant.AppConstant;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class LoginPageTest extends BaseTest {

    @Test(priority=1)
    public void loginPageNavigation(){
  loginpage=homepage.NavigateToLoginPage();
  String actualtitle=loginpage.getLoginPageTitle();
        System.out.println(actualtitle);
        Assert.assertEquals(actualtitle, AppConstant.LOGIN_PAGE_TITLE);
    }
    @Test(priority=2)
    public void forgetLink(){
      Assert.assertTrue(loginpage.isForgetpwdLinkExist());
    }
    @Test(priority=3)
    public void appLoginTest(){

        Assert.assertTrue(loginpage.doLogin(prop.getProperty("appuser").trim(),prop.getProperty("apppwd").trim()));
    }

}
