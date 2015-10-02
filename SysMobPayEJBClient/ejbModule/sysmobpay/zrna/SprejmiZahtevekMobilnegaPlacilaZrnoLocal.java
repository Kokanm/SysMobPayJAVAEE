package sysmobpay.zrna;

import java.util.List;

import javax.ejb.Local;

import SysMobPayModel.Order;

@Local
public interface SprejmiZahtevekMobilnegaPlacilaZrnoLocal {

	void sprejmiPaketPogodb(List<Order> order);

}
