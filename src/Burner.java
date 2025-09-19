
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
			case OFF:
				this.mySetting = Setting.OFF;
		}

		this.timer = TIME_DURATION;
	}
	
	public void updateTemperature() {
//		System.out.println(this.timer);
//		System.out.println("Setting:"+this.mySetting.ordinal());
//		System.out.println("Temp:" + this.myTemperature.ordinal());
		if (this.mySetting.ordinal() == this.myTemperature.ordinal()) { this.timer=0;}
		if (this.timer == 1) {
			// If max temp for setting is reached
//			System.out.println("Setting:" + this.mySetting);
//			System.out.println("Before:" + this.myTemperature);
			if (this.mySetting.ordinal() > this.myTemperature.ordinal()) {
				this.myTemperature = Temperature.values()[this.myTemperature.ordinal() + 1];
				this.timer = TIME_DURATION;
			}
			if (this.mySetting.ordinal() < this.myTemperature.ordinal()) {
				this.myTemperature = Temperature.values()[this.myTemperature.ordinal() - 1];
				this.timer = TIME_DURATION;
			}
		}
		else if (this.timer == 2) {
			this.timer = 1;
		}
//		System.out.println("After:" + this.myTemperature);
	}
	
	public void display() {
		System.out.println("[" + this.mySetting + "]....." + this.myTemperature);
	}
	
	public Temperature getTemperature() {
		return this.myTemperature;
	}
}
