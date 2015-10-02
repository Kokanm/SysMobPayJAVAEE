package sysmobpay.zrna;

import java.util.List;

import javax.ejb.Remote;

import SysMobPayModel.Order;

@Remote
public interface SprejmiZahtevekMobilnegaPlacilaZrnoRemote {
	void sprejmiPaketPogodb(List<Order> order);
}
