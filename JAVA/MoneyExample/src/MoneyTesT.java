import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTesT {

	@Test
	public void testMultiplication() {
		Money five = new Dollar(5, "USD");
		five.times(2);
		assertEquals(5, five.amount);
	}

	@Test
	public void testMultiplication2() {
		Money five = new Dollar(5, "USD");
		Money product = five.times(2);
		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(15, product.amount);
	}

	@Test
	public void testEquality() {
		assertTrue(new Dollar(5, "USD").equals(new Dollar(5, "USD")));
	}

	@Test
	public void testEquality2() {
		assertTrue(new Dollar(5, "USD").equals(new Dollar(5, "USD")));
		assertFalse(new Dollar(5, "USD").equals(new Dollar(6, "USD")));
	}

	@Test
	public void testMultiplication3() {
		Money five = new Dollar(5, "USD");
		Money product = five.times(2);
		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(15, product.amount);
	}

	@Test
	public void testMultiplication4(){
		Money five = new Dollar(5, "USD");
		Money product = five.times(2);
		assertEquals(new Dollar(10, "USD"), product);
		product = five.times(3);
		assertEquals(15, product.amount);
	}

	@Test
	public void testMultiplication5() {
		Money five = new Dollar(5, "USD");
		Money product = five.times(2);
		assertEquals(new Dollar(10, "USD"), product);
		product = five.times(3);
		assertEquals(new Dollar(15, "USD"), product);
	}

	@Test
	public void testMultiplication6() {
		Money five = new Dollar(5, "USD");
		assertEquals(new Dollar(10, "USD"), five.times(2));
		assertEquals(new Dollar(15, "USD"), five.times(3));
	}

	// We can copy and edit the Dollar test:
	@Test
	public void testFrancMultiplication() {
		Franc five = new Franc(5, "CHF");
		assertEquals(new Franc(10, "CHF"), five.times(2));
		assertEquals(new Franc(15, "CHF"), five.times(3));
	}
	
	@Test
	public void testEquality3() {

		   assertTrue(new Dollar(5, "USD").equals(new Dollar(5, "USD")));
		   assertFalse(new Dollar(5, "USD").equals(new Dollar(6, "USD")));
		   assertTrue(new Franc(5, "CHF").equals(new Franc(5, "CHF")));//Dollar icin testlerin kopyasý
		   assertFalse(new Franc(5, "CHF").equals(new Franc(6, "CHF")));
		}

	@Test
	public void testEquality4() {
		   assertTrue(new Dollar(5, "USD").equals(new Dollar(5, "USD")));
		   assertFalse(new Dollar(5, "USD").equals(new Dollar(6, "USD")));
		   assertTrue(new Franc(5, "CHF").equals(new Franc(5, "CHF")));
		   assertFalse(new Franc(5, "CHF").equals(new Franc(6, "CHF")));
		   assertFalse(new Franc(5, "CHF").equals(new Dollar(5, "USD")));
		}

	@Test
	public void testMultiplication7() {
		   Money five = Money.dollar(5);
		   assertEquals(new Dollar(10, "USD"), five.times(2));
		   assertEquals(new Dollar(15, "USD"), five.times(3));
		}
	
	@Test
	public void testMultiplication8() {
		   Money five = Money.dollar(5);
		   assertEquals(Money.dollar(10), five.times(2));
		   assertEquals(Money.dollar(15), five.times(3));
	}
	
	@Test
	public void testEquality5() {
		   assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		   assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		   assertTrue(new Franc(5, "CHF").equals(new Franc(5, "CHF")));
		   assertFalse(new Franc(5, "CHF").equals(new Franc(6, "CHF")));
		   assertFalse(new Franc(5, "CHF").equals(Money.dollar(5)));
		}

	@Test
	public void testEquality6() {
		   assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		   assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		   //assertTrue(Money.franc(5).equals(Money.franc(5)));//duplicated
		   //assertFalse(Money.franc(5).equals(Money.franc(6)));//
		   assertFalse(Money.franc(5).equals(Money.dollar(5)));
		}
	
	@Test
	public void testFrancMultiplication2() {
		   Money five = Money.franc(5);
		   assertEquals(Money.franc(10), five.times(2));
		   assertEquals(Money.franc(15), five.times(3));
		}

	@Test
	public void testCurrency() {
		   assertEquals("USD", Money.dollar(1).currency());
		   assertEquals("CHF", Money.franc(1).currency());
		}

	@Test
	public void testDifferentClassEquality() {
		   assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
		}
	
	@Test
	public void testSimpleAddition() {
		int sum=10;
		Bank bank=new Bank();
		Money reduced= bank.reduce(sum, "USD");
		   assertEquals(Money.dollar(10), reduced);
		}

}
