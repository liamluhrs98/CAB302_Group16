package stock;

public class store {

	int capital;
	String storeName = "SuperMart";
	
	public store(int capital, stock[] stocklist, String storeName) {
		this.capital = capital;
		this.storeName = storeName;
		
	}
	
	public String getStoreName() {
		return this.storeName;
	}
	
	public int getCapital() {
		return this.capital;
	}
	
}
