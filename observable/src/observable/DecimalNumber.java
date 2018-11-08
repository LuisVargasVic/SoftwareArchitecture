package observable;

public class DecimalNumber extends Observable {
	int value;
	
	public DecimalNumber() {
		super();
		this.value = 0;
	}
	
	public DecimalNumber(int value) {
		super();
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
		this.notifyObservers();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getHexString() {
		return Integer.toBinaryString(this.value);
	}
	
	public String getOctalString() {
		return Integer.toOctalString(this.value);
	}
}
