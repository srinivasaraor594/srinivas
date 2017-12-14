package MyFacilities;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.DataProvider5;
import common.GlobalVariablesCalling;
import common.MethodsCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class SimulateOwnerFacilityWithTenantLogin extends TestBase{
	@Test(priority=1,dataProvider="OwnerFacilitySimulationWithTenatLogin",dataProviderClass= DataProvider5.class)
	public void BookingFacility(String EnterFacilityNameToSearch,String EnterFromTime,String EnterToTime,String EnterDescription) throws InterruptedException, IOException, HeadlessException, AWTException{
	Reporter.log("ScriptName:Simulate with Member Login (Tenant)", true);	
	Reporter.log("----------------------------------------------------------------------------", true);
	Reporter.log(" ", true);
	helper.Navigate(GlobalVariablesCalling.EnterUrl);
	helper.DeepSleep();
	helper.SetValue1("UserName",GlobalVariablesCalling.EnterTenantUserId);
	helper.SetValue1("Password", GlobalVariablesCalling.EnterTenantPassword);
	helper.ClickByID(VariableCalling.SelectTermsAndConditions);
	helper.ClickByXpath(VariableCalling.LoginButton);
	helper.MaxSleep();
	helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
	helper.MaxSleep();
	helper.ClickElementByCssSelector(VariableCalling2.FacilityButton);
	helper.ClickByXpath(VariableCalling.ClickOnSearchButton);
	Thread.sleep(2000);
	helper.ClickByXpath(VariableCalling2.SelectFacilityNameInSearchFunction);
	Thread.sleep(4000);
	helper.SetValueByID(VariableCalling2.EnterDataToSearch, EnterFacilityNameToSearch);
	Thread.sleep(4000);
	helper.ClickByXpath(VariableCalling.ClickOnFindButton);
	Thread.sleep(4000);
	helper.ClickByXpath(VariableCalling.CloseSearchFunction);
	Thread.sleep(4000);
	WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
	List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
	try{
	List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
	String FacilityNames=FacilityColoumns.get(2).getText();
	if(FacilityNames.equals(FacilityNames)){
	Reporter.log("Added Free Facility Found Sucessfully", true);
	helper.TakeScreenShot("Search For OwnerFacility With Tenant Login");}
	try{
	String BookingButton=FacilityColoumns.get(11).findElement(By.tagName("button")).getText();
	Reporter.log("Booking Button Is There with Name Of :" +BookingButton, true);
	String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
	Reporter.log("Preice Details Button Is Exists With Name Of:"+PriceDetailsButton, true);
	if(PriceDetailsButton.equals("Show")){
	if(BookingButton.equals("Book / Cancel")){
	FacilityColoumns.get(11).findElement(By.tagName("button")).click();
	helper.MaxSleep();
	helper.Sleep();
	helper.ClickByID(VariableCalling.ClickOnAddButton);
	helper.MaxSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromDate)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromDate)).sendKeys(MethodsCalling.EnterTomorrowDate());
	helper.DeepSleep();
	helper.ClickOnTabButton("FromDate");
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromTime)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterFromTime)).sendKeys(EnterFromTime);
	helper.ClickOnTabButton("FromTime");
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToDate)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToDate)).sendKeys(MethodsCalling.EnterTomorrowDate());
	helper.ClickOnTabButton("ToDate");
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToTime)).clear();
	helper.DeepSleep();
	SeleniumHelper.driver.findElement(By.xpath(VariableCalling.EnterToTime)).sendKeys(EnterToTime);
	helper.ClickOnTabButton("ToTime");
	helper.SetValueByXpath(VariableCalling.Description, EnterDescription);
	helper.Sleep();
	try{
	helper.DeepSleep();
	helper.ClickByXpath(VariableCalling.ClickOnBookButtonInFacility);
	helper.MaxSleep();
	helper.TakeScreenShotOfWindowPopUp("Booking OwnerFacility With Tenant Login");
	helper.DeepSleep();
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	helper.DeepSleep();
		}
	catch(NoAlertPresentException e){
	Reporter.log("After Click On Submit Button No PopUp Came ", true);
	}}}			
	}catch(NoSuchElementException Exception){
	Reporter.log("Booking Button Not Available So booking Is Not Allowed For This Facility", true);
	String PriceDetailsButton=FacilityColoumns.get(12).findElement(By.tagName("a")).getText();
	Reporter.log("Preice Details Button Is Exists With Name Of:" +PriceDetailsButton, true);
	helper.TakeScreenShot("Booking Not Allowed For Facility With FreeAnd With Allow For Booking");
	Reporter.log("Booking Not Allowed For Facility With FreeAnd With Allow For Booking", true);
	}}catch(NoSuchElementException Exception){
	Reporter.log("Search With Facility Name Not Working/Facility Not Added ", true);
	}
	Reporter.log(" ", true);
	Reporter.log("Files Stored In(Path Name)", true);	
	Reporter.log("---------------------------", true);	
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Booking OwnerFacility With Tenant Login" , true);
	Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"Search For OwnerFacility With Tenant Login",true);
	Reporter.log(" ", true);
	Reporter.log("Items ToBe Checked Manually", true);	
	Reporter.log("---------------------------", true);
	Reporter.log(" SMS and Soft copy (With out Financial Posting) to Member and Moderator ", true);
	
	
	
	
		}


}
