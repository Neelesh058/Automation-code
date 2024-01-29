package co.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
private Page page;
    //1.String Locator-OR

    private String search="input[name='search']";
    private String searchIcon="div#search button";
    private String searchPageHeader="div#content h1";
    private String loginlink="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a";
    private String accountLink="a[title='My Account']";

    //2.Page constructor
    public  HomePage(Page page) {

        this.page = page;
    }

        //3. Page action/method
     public String getHomePageTitle(){
            String title=page.title();
         System.out.println("title is"+ title);
             return title;
        }
    public String HomePageUrl(){
           String url=page.url();
        System.out.println("Page url"+url);
        return url;
       }
       public String doSearch(String productName){

        page.fill(search,productName);
        page.click(searchIcon);
        String header= page.textContent(searchPageHeader);
           System.out.println("Header is"+header);
           return header;

       }
       public LoginPage NavigateToLoginPage(){
        page.click(accountLink);
         page.click(loginlink);
        return new LoginPage(page);
    }
    }

