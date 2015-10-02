package sysmobpay.zrna;

import javax.ejb.Remote;

import sysmobpay.napake.NedovoljeniPogojiPlacilaException;
import SysMobPayModel.Order;

@Remote
public interface UpravljavecObdelaveMobilnihPlacilZrnoRemote {
	Order purchaseProcess(Order order) throws NedovoljeniPogojiPlacilaException;
}
