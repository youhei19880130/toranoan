package toranoan;

public class Bean {

	/**DB上のID*/
	private String id ;
	/**DB上の商品名*/
	private String item;
	/**DB上の価格*/
	private int price;
	/**DB上のカテゴリ*/
	private String category;
	/**DB上の温冷*/
	private String hotcold;
	/**検索アイテム名(部分一致可)*/
	private String searchitem;
	/**検索カテゴリ*/
	private String searchcategory;
	/**検索結果の並び替え*/
	private String searchorder;
	/**注文時の数量*/
	private String number;

	public String toString() {
		return super.toString()
				+"id="+id
				+",item="+item
				+",price="+price
				+",category="+category
				+",hotcold="+hotcold
				;
	}

	//セッタ、ゲッタの生成
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

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getHotcold() {
		return hotcold;
	}
	public void setHotcold(String hotcool) {
		this.hotcold = hotcool;
	}

	public String getSearchitem() {
		return searchitem;
	}
	public void setSearchitem(String searchitem) {
		this.searchitem = searchitem;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getSearchcategory() {
		return searchcategory;
	}
	public void setSearchcategory(String searchcategory) {
		this.searchcategory = searchcategory;
	}
	
	public String getSearchorder() {
		return searchorder;
	}
	public void setSearchorder(String searchorder) {
		this.searchorder = searchorder;
	}
	
}