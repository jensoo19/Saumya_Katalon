package com.bank

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class AddCustomer {

	@Keyword
	public addCus(String arr1,String arr2,String arr3 ) {

		// this keyword is to let bank manager to add customer

		try {

			String Fname ="Object Repository/XYZ_BANK_OR/Page_XYZ Bank/input_First Name_form-control ng-pristine n_693e51"
			String Lname ="Object Repository/XYZ_BANK_OR/Page_XYZ Bank/input_Last Name_form-control ng-pristine ng_64913d"
			String Post ="Object Repository/XYZ_BANK_OR/Page_XYZ Bank/input_Post Code_form-control ng-pristine ng_b8fd27"
			WebUI.setText(findTestObject(Fname),arr1)

			WebUI.setText(findTestObject(Lname),arr2)

			WebUI.setText(findTestObject(Post),arr3)

			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Add Customer_1'))
		}

		catch(Exception e) {
			this.println("please enter in feild")
		}
	}

	@Keyword
	public alerthandle() {
		try {
			WebUI.waitForAlert(25)
			WebUI.acceptAlert()
		}
		catch(Exception e) {
			WebUI.waitForAlert(25)
			WebUI.acceptAlert()
		}
	}

	@Keyword
	// this keyword let bank manager to open an account for customer
	public openAccount(CusFirstName,CusLastName,CusPostCode) {

		// check for customer present or not, if not call to addcus

		WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/select_---Customer Name---       Hermoine G_a52cd8'))

		Boolean a= WebUI.verifyTextPresent(CusFirstName+" "+CusLastName, true)

		if(a==false) {

			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Home'))

			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Bank Manager Login'))

			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Add Customer'))

			addCus(CusFirstName,CusLastName,CusPostCode);
		}

		else {

			WebUI.selectOptionByValue(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/select_---Customer Name---       Hermoine G_a52cd8'),
					'6', true)

			WebUI.selectOptionByValue(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/select_---Currency---       Dollar      Pou_e54511'),
					'Rupee', true)

			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Process'))
		}
	}

	@Keyword

	//	this keyword check whether account for customer created or not

	public checkAccountcreated(check,CusFirstName,CusLastName,CusPostCode) {
		WebUI.selectOptionByValue(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/select_---Your Name---       Hermoine Grang_7c67ee'),
				'6', true)
		WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Login'))

		//		Boolean b= WebUI.verifyTextNotPresent(check,true)

		String text= WebUI.getText(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/span_Please open an account with us'))

		if(text!=check) {
			this.print("welcome")
		}

		else {
			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Home'))
			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Bank Manager Login'))
			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Open Account'))
			openAccount(CusFirstName,CusLastName,CusPostCode)
			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Home'))
			WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Customer Login'))
		}
	}


	@Keyword
	public deposit(String amountD) {
		WebUI.setText(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/input_Amount to be Deposited_form1'),
				amountD)

		WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Deposit_1'))
	}

	@Keyword
	public withdraw(String amountW) {

		//this function will take few more seconds because of dynamic object please wait! :)
		String str='code'
		TestObject code = findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/input_Amount to be Deposited_form-control n_97f4dd', [('code') : str])
		WebUI.setText(code,amountW)
		WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Withdraw'))
	}

	@Keyword
	public deleteAcc(Number) {
		//this function will take few more seconds please wait :)


		WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Bank Manager Login'))

		WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Customers'))

		WebUI.setText(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/input_Customers_form-control ng-pristine ng_ffe1ed'),
				Number)

		WebUI.click(findTestObject('Object Repository/XYZ_BANK_OR/Page_XYZ Bank/button_Delete'))

	}
}




