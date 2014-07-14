package toranoan;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeanTest {

	@Test
	public void testToString() {
		Bean bean = new Bean();
		bean.setId("id");
		bean.setItem("item");
		bean.setPrice(100);
		bean.setCategory("category");
		bean.setHotcold("hotcold");
		bean.setSearchitem("searchitem");
		bean.setSearchcategory("searchcategory");
		bean.setSearchorder("searchorder");
		bean.setNumber("number");
		assertEquals("id=id,item=item,price=100,category=category,hotcold=hotcold,searchitem=searchitem,"
				+ "searchcategory=searchcategory,searchorder=searchorder,number=number",bean.toString());
	}

}
