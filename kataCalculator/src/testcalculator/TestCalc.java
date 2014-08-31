package testcalculator;
import calculator.Calc;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCalc {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void AnEmptyStringReturnZero() {
		Calc calculator = new Calc();
		int ret = calculator.add("");
		assertEquals("Enviando string vacio y retornando cero.",0,ret);
	}
	
	@Test
	public void AddStringInputOneNumber() {
		Calc calculator = new Calc();
		int ret = calculator.add("1");
		assertEquals("Enviando un numero (1) y retornando la suma que es el mismo numero en este caso uno (1).",1,ret);
	}
	
	@Test
	public void AddStringInputSevenNumber() {
		Calc calculator = new Calc();
		int ret = calculator.add("7");
		assertEquals("Enviando un numero (7) y retornando la suma que es el mismo numero en este caso uno (7).",7,ret);
	}

	@Test
	public void AddStringInputTwoNumber() {
		Calc calculator = new Calc();
		int ret = calculator.add("1,2");
		assertEquals("Enviando dos numeros (1,2) y retornando la suma (3).",3,ret);
	}
	
	@Test
	public void AddStringInputTwoNumberFiveAddFiveEqualTen() {
		Calc calculator = new Calc();
		int ret = calculator.add("5,5");
		assertEquals("Enviando dos numeros (5,5) y retornando la suma (10).",10,ret);
	}
	
	@Test
	public void AddStringInputTwoNumberTenAddTenEqualTwenty() {
		Calc calculator = new Calc();
		int ret = calculator.add("10,10");
		assertEquals("Enviando dos numeros (10,10) y retornando la suma (20).",20,ret);
	}
	
	@Test
	public void AddStringInputThreeNumberFiveAddFiveAddTOneEqualEleven() {
		Calc calculator = new Calc();
		int ret = calculator.add("5,5,1");
		assertEquals("Enviando dos numeros (5,5,1) y retornando la suma (11).",11,ret);
	}
	
	@Test
	public void AddStringInputFourNumberTweoAddFThreeAddFourAddOneEqualTen() {
		Calc calculator = new Calc();
		int ret = calculator.add("2,3,4,1");
		assertEquals("Enviando dos numeros (2,3,4,1) y retornando la suma (10).",10,ret);
	}
	
	@Test
	public void AddStringInputTreeNumberOneAddTwoAddThreeEqualSix() {
		Calc calculator = new Calc();
		int ret = calculator.add("1\n2,3");
		assertEquals("Enviando dos numeros (1\n2,3) y retornando la suma (6).",6,ret);
	}
	
	@Test
	public void AddStringInputTwoNumberOneAddTwoEqualThreeDifferentDelimiter() {
		Calc calculator = new Calc();
		int ret = calculator.add("//;\n1;2");
		assertEquals("Enviando dos numeros (//;\n1;2) y retornando la suma (3).",3,ret);
	}
	
	@Test
	public void AddStringInputTwoNumberOTwoAddTwoEqualThreeDifferentDelimiter() {
		Calc calculator = new Calc();
		int ret = calculator.add("//@\n2@2");
		assertEquals("Enviando dos numeros (//@\n2@2) y retornando la suma (4).",4,ret);
	}

	@Test
	public void AddStringInputThrowExceptionNumberNegativeMinusOneAddTwo() {
		Calc calculator = new Calc();
		try {
			calculator.add("-1,2");
			fail("Should have thrown an IllegalArgumentException!");
		  } catch (IllegalArgumentException e) {
			  assertEquals("Handle exception","Negatives not allowed: -1",e.getMessage());
		  }
	}
	
	@Test
	public void AddStringInputThrowExceptionNumberNegativeTwoAddMinusFourAddThreAddMinusFive() {
		Calc calculator = new Calc();
		try {
			calculator.add("2,-4,3,-5");
			fail("Should have thrown an IllegalArgumentException!");
		  } catch (IllegalArgumentException e) {
			  assertEquals("Handle exception","Negatives not allowed: -4,-5",e.getMessage());
		  }
	}
	
	@Test
	public void AddStringInputTwoNumberOneHundredAddTenEqualTen() {
		Calc calculator = new Calc();
		int ret = calculator.add("1000,10");
		assertEquals("Enviando dos numeros (1000,10) y retornando la suma (10).",10,ret);
	}
	
	@Test
	public void AddStringInputTwoNumberOTwoAddTwoEqualThreeDifferentDelimiterLength() {
		Calc calculator = new Calc();
		int ret = calculator.add("//[***]\n[1***2***3]");
		assertEquals("Enviando dos numeros (//[***]\n1***2***3) y retornando la suma (6).",6,ret);
	}

}
