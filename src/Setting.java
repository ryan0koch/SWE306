/**
 * Setting class. 
 *  
 * @author Yamato Matsumura
 * @author Ryan Koch
 * 
 * Purpose: Simulates setting for the stove
 */

public enum Setting {
	OFF ("---"), LOW ("--+"), MEDIUM ("-++"), HIGH ("+++");
	private String value;
	
	Setting (String setting) {
		this.value = setting;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
