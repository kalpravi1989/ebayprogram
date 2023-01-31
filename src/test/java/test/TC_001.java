package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;

public class TC_001 extends BaseClass {
	@Test
	public void test1() {
		HomePage hp = new HomePage(driver);
hp.getList();
hp.checklist();
}
		
}
