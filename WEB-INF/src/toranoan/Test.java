package toranoan;

public class Test {
	public static void main(String[] args) {
		Bean bean = new Bean();
		bean.setId("1111");
		bean.setItem("hogehoge");
		bean.setPrice(10000);
		System.out.println(bean);
		
		Item item = new Item();
		item.setBean(bean);
		item.setVolume(4);
		System.out.println(item);
	}
}
