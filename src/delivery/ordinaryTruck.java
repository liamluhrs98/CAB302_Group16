package delivery;

public class ordinaryTruck extends truck {

	public ordinaryTruck() {
		// TODO Auto-generated constructor stub
		super("ordinary");
	}
	
	public int getCapacity() {
		return 1000;
	}
	
	public int getCost() {
		return 0;
	}
}
