package co.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    Page page;
    //1.String Locator
    private String emailid="//input[@id='input-email']";
    private String password="//input[@id='input-password']";
    private String loginbutton="//input[@value='Login']";
    private String fogetlink ="//div[@class='form-group']/a"  ;
    private  String logoutlink="//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]";

    //2.Page constructor
    public LoginPage(Page page){

        this.page=page;
    }
    //3.Page action
    public String getLoginPageTitle(){
        return page.title();
    }
    public boolean isForgetpwdLinkExist(){
        return page.isVisible(fogetlink);
    }
    public boolean doLogin(String appuser, String apppwd){
        System.out.println("App cred" +appuser+ "+" +apppwd);
  page.fill(emailid,appuser);
  page.fill(password,apppwd);
  page.click(loginbutton);
  if(page.isVisible(logoutlink)){

      System.out.println("user is looged in successfully");
      return true;
  }

        return false;
    }


}
