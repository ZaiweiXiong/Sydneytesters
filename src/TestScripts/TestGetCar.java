package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBaseSetup;
import Components.CarInsurancePage;
import Components.GetACar;
import Components.InsureancePayment;

public class TestGetCar extends TestBaseSetup {
	
	private CarInsurancePage carinsurancePage;
	private InsureancePayment insurencepayment;
	@Test(groups="sanity")
	
	public void test(){
		
		GetACar getCar = new GetACar(browser);
		carinsurancePage = getCar.clickGetAcarButton();
		Assert.assertEquals(carinsurancePage.getYear(),"Year of Manufacture");
		Assert.assertEquals(carinsurancePage.getAge(),"Enter driver's age");
		Assert.assertEquals(carinsurancePage.getmail(),"Enter your email address");
		
		carinsurancePage.clcikGetQuote();
		Assert.assertTrue(carinsurancePage.verifyYearError(),"Page text not matching");
		Assert.assertTrue(carinsurancePage.verifydriverError(),"Page text not matching");
		Assert.assertTrue(carinsurancePage.verifyEmailError(),"Page text not matching");
		
		
		carinsurancePage.selectMake().
		enterYear().enterAge().checkGender()
		.selectSate().enterEmail().clcikGetQuote();
		Assert.assertTrue(carinsurancePage.verifyPremium(),"Preminus is not matching");
		
		
		insurencepayment = carinsurancePage.clickBuy();
		Assert.assertEquals(insurencepayment.getcardholdername(),"Card Holder's Name");
		Assert.assertEquals(insurencepayment.getusername(),"Email address");
		Assert.assertEquals(insurencepayment.getpassword(),"Password");
		Assert.assertEquals(insurencepayment.getcc(),"Debit/Credit Card Number");
		Assert.assertEquals(insurencepayment.getcardcvv(),"Security Code");
		
		insurencepayment.clickPay();
		Assert.assertEquals(insurencepayment.getErrorNC(), "The name is required and cannot be empty");
		Assert.assertEquals(insurencepayment.getErrorCn(), "The credit card number is required and cannot be empty");
		Assert.assertEquals(insurencepayment.getErrorcvv(), "The cvv is required and cannot be empty");
		
		
		insurencepayment.selectMonth().selectYears().enter().clickPay();
		Assert.assertEquals(insurencepayment.getPay(), "Sucessful");
		Assert.assertTrue(insurencepayment.verifyResult(),"payment is failed");
		
		
	}

}
