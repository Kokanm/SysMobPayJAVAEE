package sysmobpay.zrna;

import javax.ejb.Local;

import SysMobPayModel.Order;

@Local
public interface UpravljavecPlacilZrnoLocal {

	Order savePayment(Order order);

}
