package pojos;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}