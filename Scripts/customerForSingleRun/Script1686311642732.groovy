import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

assert GlobalVariable.URL

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Bank Manager Login'))

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Add Customer'))

String[] arr = new String[3]

(arr[0]) = CusFirstName

(arr[1]) = CusLastName

(arr[2]) = CusPostCode

CustomKeywords.'com.bank.AddCustomer.addCus'(CusFirstName, CusLastName, CusPostCode)

CustomKeywords.'com.bank.AddCustomer.alerthandle'()

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Open Account'))

CustomKeywords.'com.bank.AddCustomer.openAccount'(CusFirstName, CusLastName, CusPostCode)

CustomKeywords.'com.bank.AddCustomer.alerthandle'()
WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Customers'))

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Home'))

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Customer Login'))

CustomKeywords.'com.bank.AddCustomer.checkAccountcreated'(check, CusFirstName, CusLastName, CusPostCode)

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Deposit'))

CustomKeywords.'com.bank.AddCustomer.deposit'(amountD)

//assert
WebUI.verifyElementText(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/span_Deposit Successful'), GlobalVariable.text1)

String var1 = WebUI.getText(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/span_Transaction successful'))

WebUI.verifyEqual(var1, GlobalVariable.text1)

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Withdrawl'))

CustomKeywords.'com.bank.AddCustomer.withdraw'(amountW)

WebUI.verifyElementText(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/span_Transaction successful'), GlobalVariable.text2)

String var = WebUI.getText(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/span_Transaction successful'))

WebUI.verifyEqual(var, GlobalVariable.text2)

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Logout'))

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Home'))

CustomKeywords.'com.bank.AddCustomer.deleteAcc'(number)

WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Home'))

WebUI.closeBrowser()

