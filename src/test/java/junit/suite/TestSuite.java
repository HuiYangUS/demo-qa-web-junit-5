package junit.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Demo Test Suite")
@SelectPackages("junit.demo")
@IncludeTags({ "demo" })
public class TestSuite {

}
