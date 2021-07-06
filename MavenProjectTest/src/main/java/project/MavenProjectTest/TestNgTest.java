package project.MavenProjectTest;

import org.testng.annotations.Test;

public class TestNgTest {
	
	@Test
	void a_Test1()
	{
		System.out.println("Hello");
	}
	
	@Test(priority=-2)
	void c_Test2()
	{
		System.out.println("I am Shreya");
	}

	@Test(priority=3)
	void b_Test3()
	{
		System.out.println("I am 26");
	}
}
