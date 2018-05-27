package delivery;

/**
 * 
 * @author Harrison Perkins
 *
 */

public class manifest {
	private String type;
	
	public manifest(String type, order order) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
