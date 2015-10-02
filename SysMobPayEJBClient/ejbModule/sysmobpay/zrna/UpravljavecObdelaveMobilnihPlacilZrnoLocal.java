package sysmobpay.zrna;

import java.util.List;

import javax.ejb.Local;

import sysmobpay.napake.NedovoljeniPogojiPlacilaException;
import SysMobPayModel.Order;

@Local
public interface UpravljavecObdelaveMobilnihPlacilZrnoLocal {
	Order purchaseProcess(Order order) throws NedovoljeniPogojiPlacilaException;

	List<SysMobPayModel.Order> getAllOrders();

	Order getOrder(int orderID);

	void updateOrder(Order order);
}
