package sysmobpay.zrna;

import javax.ejb.Local;

import SysMobPayModel.Order;
import SysMobPayModel.User;
import sysmobpay.napake.NedovoljeniPogojiPlacilaException;

@Local
public interface UpravljavecUporabnikovZrnoLocal {
	
	boolean check(Order order);

	void changeDaily(Order order) throws NedovoljeniPogojiPlacilaException;	

	boolean checkBonus(Order order);

	User getUser(Integer userID);

}
