
public class Burner {

	public enum Temperature{
		BLAZING ("VERY HOT! DON'T TOUCH"), 
		HOT ("CAREFUL"), 
		WARM ("warm"), 
		COLD ("cooool");
		private String value;
		
		Temperature (String temp) {
			this.value = temp;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	public static final int TIME_DURATION = 2;
	

	public Burner() {
		this.myTemperature = Temperature.COLD;
		this.mySetting = Setting.OFF;
		this.timer = 0;
	}
	
	public void plusButton() {
		switch (this.mySetting) {
			case OFF:
				this.mySetting = Setting.LOW;
				break;
			case LOW:
				this.mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				this.mySetting = Setting.HIGH;
				break;
			case HIGH:
				this.mySetting = Setting.HIGH;
		}
		
		timer = TIME_DURATION;
	}
	
	public void minusButton() {
		switch (this.mySetting) {
			case HIGH:
				this.mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				this.mySetting = Setting.LOW;
				break;
			case LOW:
				this.mySetting = Setting.OFF;
				break;
			case OFF:
				this.mySetting = Setting.OFF;
		}

//		timer = TIME_DURATION; Maybe need???
	}
	
	public void updateTemperature() {
		if (this.timer == 1) {
			// If max temp for setting is reached
			if (this.mySetting.ordinal() == this.myTemperature.ordinal() - 1) {
				this.myTemperature = Temperature.values()[this.myTemperature.ordinal() + 1];
				this.timer = 0;
			}
		}
		else if (this.timer == 2) {
			this.timer--;
		}

	}
	
	public void display() {
		System.out.println("[" + mySetting + "]....." + myTemperature);
	}
	
	public Temperature getTemperature() {
		return myTemperature;
	}
}
