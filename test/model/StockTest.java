package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StockTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testStock() {
		for(int i = -1; i < 10; i++) {
			Stock s = new Stock("ABC", i, i);
			if(s.getName() == null) continue;
			assertTrue(s.getSymbol().equals("ABC"));
			assertTrue(s.getCurrentPrice() == i && s.getQuantity() == i);
		}

	}

//	@Test
//	public final void testGenerateName() {
//		fail("Not yet implemented"); // TODO
//	}

//	@Test
//	public final void testGetSpotPrice() {
//		fail("Not yet implemented"); // TODO
//	}

	@Test
	public final void testUpdate() {
		Stock s = new Stock("ABC", 5,5.0);
		int expectedQuant = 5;
		for(int i = -5; i < 10; i++) {
			s.update(i);
			expectedQuant += i;
			if(expectedQuant <0) expectedQuant = 0;
			assertTrue(s.getQuantity() == expectedQuant);
		}
	}

//	@Test
//	public final void testToString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	public final void testStockInfo() {
//		fail("Not yet implemented"); // TODO
//	}

}
