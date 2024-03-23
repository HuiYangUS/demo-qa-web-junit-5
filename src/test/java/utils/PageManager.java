package utils;

import pages.DemoLoginPage;

public class PageManager {

    private static ThreadLocal<PageManager> localPageManager;
    private DemoLoginPage demoLoginPage;

    private PageManager() {
	// WARN: Nothing should be written here.
    }

    public static synchronized PageManager getInstance() {
	if (localPageManager == null)
	    localPageManager = new ThreadLocal<PageManager>();
	if (localPageManager.get() == null)
	    localPageManager.set(new PageManager());
	return localPageManager.get();
    }

    public static void reset() {
	if (localPageManager.get() != null)
	    localPageManager.set(null);
    }

    public DemoLoginPage demoLoginPage() {
	if (demoLoginPage == null)
	    demoLoginPage = new DemoLoginPage();
	return demoLoginPage;
    }

}