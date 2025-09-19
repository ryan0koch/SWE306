/**
 * Burner class. 
 *  
 * @author Yamato Matsumura
 * @author Ryan Koch
 * 
 * Purpose: Logic for controlling the burners
 */

public class Burner {

	public enum Temperature{
		COLD ("cooool"),
		WARM ("warm"), 
		HOT ("CAREFUL"), 
		BLAZING ("VERY HOT! DON'T TOUCH");

		
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
		
		// Starting timer goes to 0
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
			// Keep on high is already on high
			case HIGH:
				this.mySetting = Setting.HIGH;
				break;
		}
		this.timer = TIME_DURATION;
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
			// Keep on OFF if already on OFF
			case OFF:
				this.mySetting = Setting.OFF;
		}

		this.timer = TIME_DURATION;
	}
	
	public void updateTemperature() {
		if (this.mySetting.ordinal() == this.myTemperature.ordinal()) { this.timer=0;} // If setting and temperature agree then set timer to 0
		
		// If temperature needs to change
		if (this.timer == 1) {
			if (this.mySetting.ordinal() > this.myTemperature.ordinal()) {
				// Increase temperature to one higher than currently set
				this.myTemperature = Temperature.values()[this.myTemperature.ordinal() + 1];
				this.timer = TIME_DURATION;
			}
			if (this.mySetting.ordinal() < this.myTemperature.ordinal()) {
				// Decrease temperature to one lower than currently set
				this.myTemperature = Temperature.values()[this.myTemperature.ordinal() - 1];
				this.timer = TIME_DURATION;
			}
		}
		
		// Update normally if no changes need to be made
		else if (this.timer == 2) {
			this.timer = 1;
		}
	}
	
	public void display() {
		System.out.println("[" + this.mySetting + "]....." + this.myTemperature);
	}
	
	public Temperature getTemperature() {
		return this.myTemperature;
	}
}
