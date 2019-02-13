package allchapters;

public class ReallySingleton {
	private int qty = 0;
	private ReallySingleton() {}
	private static final ReallySingleton INSTANCE = new ReallySingleton();
	public static ReallySingleton getInstance() {
		return INSTANCE;
	}
	public String hiMe() {
		return "HiMe";
	}

}
