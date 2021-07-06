package project.MavenProjectTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Annotations {
	
	void randomtest1()
	{
		System.out.println("randomtest1");
	}
	
	@Test(groups= {"1","2"})
	void Test1()
	{
		System.out.println("Test 1");
	}
	
	@Test(groups= {"2","3"})
	void Test2()
	{
		System.out.println("Test 2");
	}
	
	@BeforeSuite
	void BeforeSuite()
	{
		System.out.println("BeforeSuite 1");
	}
	
	@AfterSuite
	void AfterSuite()
	{
		System.out.println("AfterSuite 1");
	}
	
	@BeforeMethod
	void BeforeMethod()
	{
		System.out.println("BeforeMethod 1");
	}
	
	@AfterMethod
	void AfterMethod()
	{
		System.out.println("AfterMethod 1");
	}
	
	@AfterMethod
	void AfterMethod2()
	{
		System.out.println("AfterMethod 2");
	}
	
	@BeforeClass
	void BeforeClass()
	{
		System.out.println("BeforeClass 1");
	}
	
	@AfterClass
	void AfterClass()
	{
		System.out.println("AfterClass 1");
	}
	
	
	@Test(groups= {"3","4"})
	void Test3()
	{
		System.out.println("Test 3");
	}
	
	void randomtest2()
	{
		System.out.println("random test 2");
	}
	
	@BeforeTest
	void BeforeTest()
	{
		System.out.println("BeforeTest 1");
	}
	
	@AfterTest
	void AfterTest()
	{
		System.out.println("AfterTest 1");
	}
	
	
}
