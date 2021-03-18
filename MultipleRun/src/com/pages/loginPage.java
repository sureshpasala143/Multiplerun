package com.pages;

 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

    WebDriver driver;
    
    
    @FindBy(xpath="//*[@id='nav-signin-tooltip']/a/span")
    						  WebElement signbtn;
    @FindBy(name="email")     WebElement username;
    @FindBy(id="continue")     WebElement continbtn;
    @FindBy(name="password")    WebElement password;
    @FindBy(id="signInSubmit")  WebElement signin;
    @FindBy(id="auth-fpp-link-bottom") WebElement forgotpassword;
    @FindBy(id="ap-other-signin-issues-link") WebElement otherissues;
    @FindBy(id="createAccountSubmit") WebElement createnewaccount;
    @FindBy(id="twotabsearchtextbox") WebElement search;

    

    public loginPage(WebDriver ldriver){

        this.driver = ldriver;

    }

    

       	public void login(String user, String pwd,String item, String amnt){
       	    
       	    String txt=signbtn.getText();
       	    System.out.println(txt);
       		signbtn.click();
       		
       		username.sendKeys(user);
       		continbtn.click();
       		password.sendKeys(pwd);
       		signin.click();
       		search.sendKeys(item);
       		
       	}

}