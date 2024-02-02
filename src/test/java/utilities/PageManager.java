package utilities;

import pages.demo.InventoryPage;
import pages.demo.LoginPage;

public class PageManager {

	private static ThreadLocal<PageManager> localManager;

	private static LoginPage loginPage;
	private static InventoryPage inventoryPage;

	private PageManager() {
	}

	public static synchronized PageManager getInstance() {
		if (localManager == null)
			localManager = new ThreadLocal<PageManager>();
		if (localManager.get() == null)
			localManager.set(new PageManager());
		return localManager.get();
	}

	public static void reset() {
		if (localManager.get() != null)
			localManager.set(null);
		tearDown();
	}

	private static void tearDown() {
		if (loginPage != null)
			loginPage = null;
	}

	public LoginPage loginPage() {
		getInstance();
		if (loginPage == null)
			loginPage = new LoginPage();
		return loginPage;
	}

	public InventoryPage inventoryPage() {
		getInstance();
		if (inventoryPage == null)
			inventoryPage = new InventoryPage();
		return inventoryPage;
	}

}
