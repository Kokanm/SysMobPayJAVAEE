package sysmobpay.napake;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class NedovoljeniPogojiPlacilaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Nedovoljeni pogoji placila!";
	}

}
