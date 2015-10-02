package si.fri.prpo;

import java.io.Serializable;


public abstract class Entiteta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
}
