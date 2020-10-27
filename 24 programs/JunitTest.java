package implementation;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class HomeworkJunitTest {

	@Test
	public void test() {
//		In the test class we assert that the 7 Fibonacci numbers must be equal to
//		0,1,1,2,3,5,8,13 by writing the expected value and calling the fib method to generate
//		the number. If the fib fails at generating the right number, it will throw an Asser-
//		tionError with a message showing which number it failed to generate, and the JUnit
//		framework will show the infamous red bar of a failed test.
		
		Homework obj = new Homework();
		ArrayList<Integer> actual = new ArrayList<>();
		ArrayList<Integer> expected = new ArrayList<>();
		actual.addAll(obj.fibonacciNumbers());
		int[] arr = {0,1,1,2,3,5,8,13};
		
		for(int i=0;i<arr.length;i++)
			expected.add(arr[i]);
		
		Assert.assertTrue(expected.equals(actual));
	}
	
	@Test
	public void stringTest() {
		String str ="this is a test";
		Stringmanip strObj = new Stringmanip(str);
		String actual = strObj.upperCase();
		String expected = "THIS IS A TEST";
		Assert.assertTrue(expected.equals(actual));
		System.out.println("actual string : "+actual);
	}

}
