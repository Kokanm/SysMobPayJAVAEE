package sysmobpay.zrna;

import javax.ejb.Remote;

import SysMobPayModel.Order;

@Remote
public interface UpravljavecObvestilZrnoRemote {

	void prepareReceipt(Order order);

}
