package Base;
import java.io.FileInputStream;
import java.util.Properties;

public class InputData {
	
	private String attributeName = "";

	private static Properties props;
	
	static {
		if (props == null) {
			props = new Properties();
		
				try {
					props.load(new FileInputStream("data/input_data.properties"));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	
	public Cars getCars() {
		
		attributeName = "cars";
		return new Cars();
	}

	public class Cars {
		
		public String getMakename() {
			attributeName += "." + "carname";
			return InputData.this.toString();
		}

		public String getYears() {
			attributeName += "." + "carYears";
			return InputData.this.toString();
		}
		
		public String getAge() {
			attributeName += "." + "carAge";
			return InputData.this.toString();
		}
		
		public String getGender() {
			attributeName += "." + "Gender";
			return InputData.this.toString();
		}
		public String getState() {
			attributeName += "." + "State";
			return InputData.this.toString();
		}
		public String getEmail() {
			attributeName += "." + "Email";
			return InputData.this.toString();
		}
		
	}
	public Payments getPayment(){
		attributeName = "payment";
		return new Payments();
	}
	public class Payments{
		public String getCardName() {
			attributeName += "." + "cardName";
			return InputData.this.toString();
		}
		
		public String getUserEmail() {
			attributeName += "." + "UserEmail";
			return InputData.this.toString();
		}
		public String getPassword() {
			attributeName += "." + "Password";
			return InputData.this.toString();
		}
		public String getCardNumber() {
			attributeName += "." + "CardNumber";
			return InputData.this.toString();
		}
		public String getCardcvv() {
			attributeName += "." + "Cardcvv";
			return InputData.this.toString();
		}
		public String getMonth() {
			attributeName += "." + "Month";
			return InputData.this.toString();
		}
		public String getYears() {
			attributeName += "." + "Years";
			return InputData.this.toString();
		}

	}
	
	
	public String toString() {
		return props.getProperty(attributeName); 
	}
}
