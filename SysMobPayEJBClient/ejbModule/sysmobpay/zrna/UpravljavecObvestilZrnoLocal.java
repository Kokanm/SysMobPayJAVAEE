package sysmobpay.zrna;

import javax.ejb.Local;

import SysMobPayModel.Order;

@Local
public interface UpravljavecObvestilZrnoLocal {

	void prepareReceipt(Order order);

}
