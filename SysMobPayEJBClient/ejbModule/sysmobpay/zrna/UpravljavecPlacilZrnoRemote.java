package sysmobpay.zrna;

import javax.ejb.Remote;

import SysMobPayModel.Order;

@Remote
public interface UpravljavecPlacilZrnoRemote {

	Order savePayment(Order order);

}
