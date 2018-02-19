package Components;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.InputData;

public class InsureancePayment {
		
	protected WebDriver driver;
	protected InputData inputData;
	//Defined the elements from page

	
	private By els = By.xpath("//input[contains(@class,'')]");
	private By selectMonth = By.name("expiry-month");
	private By selectYear = By.name("expiry-year");
	private By payNow = By.name("pay");
	
	private By Nd= By.cssSelector("small[data-bv-for='cardholdername'][data-bv-result='INVALID']");
		 //By.xpath(" //*[@id='ccForm']/fieldset/div[1]/div/small");
	//Name on Card
	private By cn=  By.cssSelector("small[data-bv-for='cc'][data-bv-result='INVALID']");
		 //By.xpath("//*[@id='ccForm']/fieldset/div[4]/div/small");
	//Card Number
	private By cvv=  By.cssSelector("small[data-bv-for='cvv'][data-bv-result='INVALID']");
	    //By.xpath("//*[@id='ccForm']/fieldset/div[6]/div/small");
	//Card cvv
	
	private By paymeantS = By.xpath("//*[@id='quotebox']/div/div[1]/h3/i");
	private By premiumResultform = By.xpath("//*[@id='premiumResultform']/div/dt");
	
	private By cardholdername = By.name("cardholdername");
	private By username = By.name("username");
	private By password = By.name("password");
	private By cc = By.name("cc");
	private By cardcvv = By.name("cvv");
	
	private String name; 
	private String email;
	private String ppassword; 
	private String cardNumber;  
	private String pcardcvv; 
	private String month;  
	private String year;  
	
	/*
    //PaymentPage 
    private By nameOnCard = By.cssSelector("#cardholdername");
	private By emailUsrname = By.cssSelector("input[id='username'][class='form-control']");
	private By password = By.cssSelector("input[id='password'][class='form-control']");
	private By cardNumber = By.cssSelector("#card-number");
	private By expirationMonth = By.cssSelector("#expiry-month");
	private By expirationYear = By.cssSelector("[name='expiry-year']");
	private By cardCVV = By.cssSelector("#cvv");	
	private By payNowButton= By.cssSelector("#pay");
	*/
	
	//Defined the method for InsureancePayment page
	public InsureancePayment(WebDriver driver){
		
		inputData = new InputData();
		this.name = inputData.getPayment().getCardName();
		this.email = inputData.getPayment().getUserEmail();
		this.ppassword=inputData.getPayment().getPassword();
		this.cardNumber=inputData.getPayment().getCardNumber();
		this.pcardcvv =inputData.getPayment().getCardcvv();
		this.month =   inputData.getPayment().getMonth();
		this.year=    inputData.getPayment().getYears();
		this.driver=driver;
	}
	public String getcardholdername(){
		return driver.findElement(cardholdername).getAttribute("placeholder");
	}
	public String getusername(){
		return driver.findElement(username).getAttribute("placeholder");
	}
	public String getpassword(){
		return driver.findElement(password).getAttribute("placeholder");
	}
	public String getcc(){
		return driver.findElement(cc).getAttribute("placeholder");
	}
	public String getcardcvv(){
		return driver.findElement(cardcvv).getAttribute("placeholder");
	}
	
	public InsureancePayment selectMonth(){
		Select dropdown = new Select(driver.findElement(selectMonth));
		dropdown.selectByVisibleText(month);
		wait(3);
		return this;
	}
	public InsureancePayment selectYears(){
		Select dropdown = new Select(driver.findElement(selectYear));
		dropdown.selectByVisibleText(year);
		wait(3);
		return this;
	}
	public InsureancePayment enter(){
	
		List<WebElement> eles = driver.findElements(els);
		for(int i=0;i<eles.size();i++){
			if(eles.get(i).isDisplayed()){
				
				if(eles.get(i).getAttribute("name").equals("cardholdername")){
					eles.get(i).sendKeys(name);
					wait(3);
				}else if(eles.get(i).getAttribute("name").equals("username")){
					eles.get(i).sendKeys(email);
					wait(3);
					
				}else if(eles.get(i).getAttribute("name").equals("password")){
					eles.get(i).sendKeys(ppassword);
					wait(3);
				}else if(eles.get(i).getAttribute("name").equals("cc")){
					eles.get(i).sendKeys(cardNumber);
					wait(3);
				}else if(eles.get(i).getAttribute("name").equals("cvv")){
					eles.get(i).sendKeys(pcardcvv);
					wait(3);
				}
			}
			
		}
		
			return this;
	}
	
	public InsureancePayment clickPay(){
		driver.findElement(payNow).click();
		wait(6);
		return this;
		}
	
	public String getPay(){
		return driver.findElement(paymeantS).getText();
	}
	public String getResult(){
		return driver.findElement(premiumResultform).getText();
	}
	public boolean verifyResult(){
		return !getResult().contains("less than");
	}
	
	public String getErrorNC(){
		
		return driver.findElement(Nd).getText();
	}
	public String getErrorCn(){
		
		return driver.findElement(cn).getText();
	}
	public String getErrorcvv(){
		return driver.findElement(cvv).getText();
	}

public void wait(int sec){
	
	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	
	}
}
