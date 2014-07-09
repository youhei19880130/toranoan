package toranoan;

public class Item {
	/**注文商品のID*/
	private String id;
	/**注文商品のアイテム名*/
	private String item;
	/**注文商品の値段*/
	private int price;
	/**注文商品の数量*/
	private int volume;
	
	public String toString() {
		return super.toString()
				+"id="+id
				+",item="+item
				+",price="+price
				+",volume="+volume
				;
	}
	
	public void setBean(Bean bean){
		String preid = bean.getId();
		String preitem = bean.getItem();
		int preprice = bean.getPrice();
		setId(preid);
		setItem(preitem);
		setPrice(preprice);
	}
	
	// セッター・ゲッター作成
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}
