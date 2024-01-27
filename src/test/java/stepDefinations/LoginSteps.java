package stepDefinations;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DataReader;

public class LoginSteps {
WebDriver driver;
HomePage hp;
LoginPage lp;
MyAccountPage macc;


List<HashMap<String,String>> datamap;

@Given("the user is navigates to login page")
public void the_user_is_navigates_to_login_page() {
	
	BaseClass.getLogger().info("Goto my account  -->Click on login..");
	hp= new HomePage(BaseClass.getDriver());
	hp.clickMyAccount();
	hp.clickLogin();
}
	
	
@When("user enters email as {string} and password as {string}")	
	public void user_enters_email_as_and_password_as(String email, String pwd)
	{
	BaseClass.getLogger().info("Entering email and password.....");
	lp= new LoginPage(BaseClass.getDriver());
	lp.setEmail(email);
	lp.setPassword(pwd);
	}
	
@When("the user clicks on the Login button")	
public void click_on_login_button() {
	lp.clickLogin();
	BaseClass.getLogger().info("clicked on login button..");
	
	
}

@Then("the user should be redirected to the My Account page")
public void user_should_be_redirected_to_the_My_Account_page() {
	
	macc=new MyAccountPage(BaseClass.getDriver());
	boolean targetpage= macc.isMyAccountPageExists();
	Assert.assertEquals(targetpage, true);
	
	
	
}



//******************Data Driven test***********//
@Then ("the user should redirected to the MyAccount Page by passing email and password with excel row{string}")

public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)


{
	
	datamap=DataReader.data(System.getProperty("user.dir")+"\\testdata\\Opencart_LoginData.xlsx");
	
	int index= Integer.parseInt(rows)-1;
	String email=datamap.get(index).get("username");
	String pwd=datamap.get(index).get("password");
	String exp_res= datamap.get(index).get("res");
	
	
	lp= new LoginPage(BaseClass.getDriver());
	lp.setEmail(email);
	lp.setPassword(pwd);
	
	lp.clickLogin();
	macc= new MyAccountPage(BaseClass.getDriver());
	try
	(
			booloan targetpage= macc.isMyAccountExists();
			System.out.println("target page:"+ targetpage);
			
			if(exp_res.equals("Valid"))
			{
				MyAccountPage myaccpage= new MyAccountPage(BaseClass.getDriver());
				myaccpage.clickLogut();
				Assert.assertTrue(true);
			}
			else {
				
				Assert.assertTrue(false);
			}
			
			
			
			)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}







	
	
	
	
	
	
	
	
	
	
	
	
	
}
