package Components;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetACar {

	protected WebDriver driver;
	
	//Defined the elements from page
	private By getcarquote = By.name("getcarquote");
	
	public GetACar(WebDriver driver){
		this.driver=driver;
	}
	//Defined the method for GetACar page
	public CarInsurancePage clickGetAcarButton(){
		
		System.out.println("click getACar button....");
		driver.findElement(getcarquote ).click();
		wait(6);
		return new CarInsurancePage(driver);
	}
	
	public void wait(int sec){
		
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		
	}
	
	
}
