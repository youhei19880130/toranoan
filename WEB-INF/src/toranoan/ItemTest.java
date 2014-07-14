package toranoan;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testToString() {
		Item item = new Item();
		item.setId("id");
		item.setItem("item");
		item.setPrice(100);
		item.setVolume(100);
		assertEquals("id=id,item=item,price=100,volume=100",item.toString());
	}

}
