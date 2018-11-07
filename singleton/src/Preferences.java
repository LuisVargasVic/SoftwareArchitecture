public class Preferences {
	private static Preferences uniqueInstance = null;
	private boolean shareInfo;
		
	public Preferences(){
		this.shareInfo = false;
	}

	public static Preferences getUniqueInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Preferences();
		}
		return uniqueInstance;
	}
	
	public void setShareInfo(boolean value){
		this.shareInfo = value;
	}
	
	public String toString(){
		return "User's Preferences:\nShare information: " + this.shareInfo; 
	}
}
