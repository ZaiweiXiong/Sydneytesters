package Components;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Base.InputData;


public class CarInsurancePage {
	
	protected WebDriver driver;
	protected InputData inputData;
	
	//Defined the elements from page
	private By Make = By.cssSelector("#make");
	private By Year = By.cssSelector("#year");     
	private By Age  =  By.cssSelector("#age");     
	private By female = By.cssSelector("#female");
	private By male =  By.cssSelector("#male");   
	private By State = By.cssSelector("#state");  
	private By email = By.cssSelector("#email"); 
	
	private By preminum = By.cssSelector("dd[class='mark']");
    private By getQuote = By.cssSelector("button#getquote");

	
	private By yearerror= 
			By.cssSelector("small[data-bv-for='year'][data-bv-result='INVALID']");
	//By.xpath("//*[@id='quoteform']/div[2]");
	private By drivererror= 
			By.cssSelector("small[data-bv-for='age'][data-bv-result='INVALID']");
	//By.xpath("//*[@id='quoteform']/div[3]");
	private By emailerror= 
			By.cssSelector("small[data-bv-for='email'][data-bv-result='INVALID']");
	//By.xpath("//*[@id='quoteform']/div[6]");
	
	private By year = By.name("year");
	private By age = By.name("age");
	private By buy = By.name("payment");
	
	private  String makeName;
	private  String years;
	private  String driverage;
	private  String gender ;
	private  String state ;
	private  String mail ;
	
	/*  
	CarPage 
	private By dropdownMake = By.cssSelector("#make");
	private By year = By.cssSelector("#year");
	private By age = By.cssSelector("#age");
	private By gender = By.cssSelector(".radio-inline");
	private By state = By.cssSelector("#state");
	private By email = By.cssSelector("#email");	
	private By getQuoteButton= By.cssSelector("button#getquote");
	By PayMsg = By.cssSelector(".panel-title.text-center>i");
	*/
	
	//Defined the method for CarInsurancePage page
	public CarInsurancePage(WebDriver driver){
		inputData = new InputData();
		this.makeName = inputData.getCars().getMakename();
		this.years    = inputData.getCars().getYears();
		this.driverage = inputData.getCars().getAge();
		this.gender = inputData.getCars().getGender();
		this.state =  inputData.getCars().getState();
		this.mail =   inputData.getCars().getEmail();
		this.driver=driver;
	}
	
	public CarInsurancePage clcikGetQuote(){
		driver.findElement(getQuote).click();
		return this;
	}
	
	public String getError(){
		
		return driver.findElement(yearerror).getText();
	}
	public String getYear(){
		
		return driver.findElement(year).getAttribute("placeholder");
	}
	public String getAge(){
		return driver.findElement(age).getAttribute("placeholder");
	}
	public String getmail(){
		return driver.findElement(email).getAttribute("placeholder");
	}
	public String getErrorwithdriverAge(){
		
		
		return driver.findElement(drivererror).getText();
	}
	public String getEmailError(){
		
		
		return driver.findElement(emailerror).getText();
	}
	
	public CarInsurancePage selectMake(){
		
		Select dropdown = new Select(driver.findElement(Make));
		dropdown.selectByVisibleText(makeName);
		wait(3);
		return this;
	}
	public CarInsurancePage enterYear(){
		driver.findElement(Year).sendKeys(years);
		wait(3);
		return this;
	}
	
	public CarInsurancePage enterAge(){
		driver.findElement(Age).sendKeys(driverage);
		wait(3);
		return this;
	}
	public CarInsurancePage checkGender(){
		if(gender.equals("female")){
			driver.findElement(female).click();
		}else{
			driver.findElement(male).click();
		}
		return this;
	}
	public CarInsurancePage selectSate(){
		Select dropdown = new Select(driver.findElement(State));
		dropdown.selectByVisibleText(state);
		wait(3);
		return this;
	}
	public CarInsurancePage enterEmail(){
		driver.findElement(email).sendKeys(mail);
		wait(3);
		return this;
	}
	
	public InsureancePayment clickBuy(){
		driver.findElement(buy).click();
		wait(3);
		return new InsureancePayment(driver);
	}
	
	public boolean verifyPremium(){
		
		String regex = "[$][0-9]+([,.][0-9]{1,2})?";
		String p = driver.findElement(preminum).getText();
		System.out.println("p->"+p);
		return p.matches(regex);
		
	}
	
	public boolean verifyYearError(){
		
		return getError().contains("The year is required");
	}
	
	public boolean verifydriverError(){
		
		return getErrorwithdriverAge().contains("The age is required. Numeric, bigger than zero.");
	}

	public boolean verifyEmailError(){
	
		return getEmailError().contains("The email is required");
	}
	
	
		
	public void wait(int secon){
		
		if(driver.findElements(By.name("ss")).isEmpty()){
			driver.manage().timeouts().implicitlyWait(secon, TimeUnit.SECONDS);	
		}
		
	}
	
	
}
