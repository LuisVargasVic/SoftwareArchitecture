public class ClientApp {

	public static void main(String[] args) {
		Preferences pref = Preferences.getUniqueInstance();
		pref.setShareInfo(true);
		System.out.println(pref.toString());
		pref = Preferences.getUniqueInstance();
		System.out.println(pref.toString());

	}
}
