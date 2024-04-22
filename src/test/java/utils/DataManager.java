package utils;

public class DataManager {

	private static ThreadLocal<DataManager> localDataManager;
	private String password;
	private WebUtils webUtils;

	private DataManager() {
		// WARN: Nothing should be written here.
	}

	public static DataManager getInstance() {
		if (localDataManager == null)
			localDataManager = new ThreadLocal<DataManager>();
		if (localDataManager.get() == null)
			localDataManager.set(new DataManager());
		return localDataManager.get();
	}

	public static void reset() {
		// LocalDataManager cannot be null
		if (localDataManager != null && localDataManager.get() != null)
			localDataManager.remove();
	}

	public String getPasswordValue() {
		if (password == null)
			throw new RuntimeException("Data Manager does not have the password value.");
		return password;
	}

	public void setPasswordValue(String password) {
		this.password = password;
	}

	public WebUtils webUtils() {
		if (webUtils == null)
			webUtils = new WebUtils(DriverManager.getDriver());
		return webUtils;
	}

}
