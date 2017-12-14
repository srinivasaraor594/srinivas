package dashboard;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import common.GlobalVariablesCalling;
import common.TestBase;
import common.VariableCalling;

public class MemberAttendanceregistor extends TestBase {
	@Test(priority = 1)
	public void AttendanceRegistor() throws Exception {
		Reporter.log("Script Name:Member---->Application--->AttendanceRegister", true);
		Reporter.log("----------------------------------------------", true);
		Reporter.log(" ", true);
		helper.Navigate(GlobalVariablesCalling.EnterUrl);
		helper.SetValue1("UserName", GlobalVariablesCalling.EnterMemberUserId);
		helper.SetValue1("Password", GlobalVariablesCalling.EnterMemberPassword);
		helper.ClickByID(VariableCalling.SelectTermsAndConditions);
		helper.ClickByXpath(VariableCalling.LoginButton);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnApplicationButton);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnAttendanceRegister);
		helper.DeepSleep();
		helper.TakeScreenShot("MemberAttendanceRegister");
	}

	@Test(priority = 2)
	public void Export() throws InterruptedException, IOException, HeadlessException, AWTException {
		helper.ClickByXpath(VariableCalling.ClickOnExportButtonInAttendanceregistor);
		helper.DeepSleep();
		helper.ClickByXpath(VariableCalling.ClickOnPdfButtonInAttendanceRegistor);
		helper.DeepSleep();
		helper.TakeScreenShotOfExportPDF("MemberAttendanceRegisterPdf");
	}

	@Test(priority = 5)
	public void Results() {
		Reporter.log(" ", true);
		Reporter.log("Files Stored in (Path Name)", true);
		Reporter.log("-----------------------------", true);
		Reporter.log("File Name : " + GlobalVariablesCalling.ScreenShotsFileName + "MemberAttendanceRegister.png",
				true);
		Reporter.log("File Name : " + GlobalVariablesCalling.ScreenShotsFileName + "MemberAttendanceRegisterPdf.png",
				true);
		Reporter.log(" ", true);
	}
}
