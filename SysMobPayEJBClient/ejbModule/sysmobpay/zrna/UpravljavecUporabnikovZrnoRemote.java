package sysmobpay.zrna;

import javax.ejb.Remote;

import SysMobPayModel.Order;
import sysmobpay.napake.NedovoljeniPogojiPlacilaException;

@Remote
public interface UpravljavecUporabnikovZrnoRemote {
	
	boolean check(Order order);

	void changeDaily(Order order) throws NedovoljeniPogojiPlacilaException;	

	boolean checkBonus(Order order);
	
}
