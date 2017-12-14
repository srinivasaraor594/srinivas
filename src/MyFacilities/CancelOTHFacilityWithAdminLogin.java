package MyFacilities;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.DataProvider6;
import common.GlobalVariablesCalling;
import common.SeleniumHelper;
import common.TestBase;
import common.VariableCalling;
import common.VariableCalling2;
public class CancelOTHFacilityWithAdminLogin extends TestBase{
@Test(dataProvider="CancelOTHFacility",dataProviderClass=DataProvider6.class)
public void CancelFacility(String AdddedFacilityName,String FacilityName,String DescriptionOfFacility) throws InterruptedException, IOException, HeadlessException, AWTException{
Reporter.log("ScriptName:Admin Login - Community (OTH) Booked for 2 hours (12:01 to 2:00 PM)  - Cancel", true);	
Reporter.log("----------------------------------------------------------------------------------------", true);
Reporter.log(" ", true);
helper.Navigate(GlobalVariablesCalling.EnterUrl);
helper.DeepSleep();
helper.SetValue1("UserName",GlobalVariablesCalling.EnterAdminUserId);
helper.SetValue1("Password", GlobalVariablesCalling.EnterAdminPassword);
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
helper.SetValueByID(VariableCalling2.EnterDataToSearch, AdddedFacilityName);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.ClickOnFindButton);
Thread.sleep(4000);
helper.ClickByXpath(VariableCalling.CloseSearchFunction);
Thread.sleep(4000);
WebElement FacilityTable=SeleniumHelper.driver.findElement(By.cssSelector(VariableCalling2.IdentifyFacilityTable));
List<WebElement>FacilityRows=FacilityTable.findElements(By.tagName(VariableCalling2.IdentifyingNumberOfRowsInTable));
List<WebElement>FacilityColoumns=FacilityRows.get(1).findElements(By.tagName(VariableCalling2.IdentifyingNumberOfColoumnsInTable));
String FacilityNames=FacilityColoumns.get(2).getText();
if(FacilityNames.equals(FacilityName)){
Reporter.log("Added OTH Facility Found Sucessfully", true);
FacilityColoumns.get(11).findElement(By.tagName("button")).click();
helper.MaxSleep();
helper.DeepSleep();
Method6.CancelFacility(DescriptionOfFacility);
helper.DeepSleep();
helper.TakeScreenShotOfWindowPopUp("AfterClickedOnCancelButtonOfOTHFacility");
try{
helper.ProcessAlert();
helper.MaxSleep();
helper.TakeScreenShot("FacilityCalendarAfterCancelOTHFacility");
Reporter.log("Meeting Cancelled", true);
}
catch(NoAlertPresentException e){
Reporter.log("facility Cancellation Popup not came", true);
}}
Reporter.log(" ", true);
Reporter.log("Files Stored In(Path Name)", true);	
Reporter.log("---------------------------", true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"AfterClickedOnCancelButtonOfOTHFacility",true);
Reporter.log("File Name : "+GlobalVariablesCalling.ScreenShotsFileName+"FacilityCalendarAfterCancelOTHFacility",true);
Reporter.log(" ", true);
Reporter.log("Items To Be Checked Manually", true);
Reporter.log("---------------------------", true);	
Reporter.log(" SMS and Soft copy (With Financial Posting) Member and Moderator", true);
Reporter.log(" Cancellation Charges of Rs. 0 to be posted (Another Soft copy of the invoice to be sent ONLY to Member)", true);
Reporter.log("Check Colour Of Cancel Event In screenshot", true);
			
}}
			
			
			
			
			



