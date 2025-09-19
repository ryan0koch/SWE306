
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