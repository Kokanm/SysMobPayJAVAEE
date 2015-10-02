package fri.uni.lj.si.prpo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.json.JsonObject;

import SysMobPayModel.Order;
import SysMobPayModel.Orderdetail;
import SysMobPayModel.Product;
import sysmobpay.zrna.UpravljavecObdelaveMobilnihPlacilZrnoLocal;

@RequestScoped
@Path("/sysmobpay")
public class SysMobPayREST implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Context
	private UriInfo context;
	
	@EJB
	private UpravljavecObdelaveMobilnihPlacilZrnoLocal uompz;

	/**
	 * Default constructor.
	 */
	public SysMobPayREST() {
		
	}
	
	@GET
	@Produces("application/json")
	public List<Order> getAllOrders() {
		List<Order> Order = uompz.getAllOrders();
		return Order;
	}

	@GET
	@Produces("application/json")
	@Path("/{orderID}")
	public Order vrniPogodbo(@PathParam("orderID") int orderID) {
		Order order = uompz.getOrder(orderID);
		return order;
	}

	@GET
	@Produces("application/json")
	@Path("/{orderID}/orderDetails")
	public List<Orderdetail> vrniAnekse(@PathParam("orderID") Integer orderID) {
		Order order = uompz.getOrder(orderID);
		List<Orderdetail> od = order.getOrderdetails();
		return od;
	}
	
	@POST
	@Consumes("application/json")
	@Path("/{orderID}")
	public void posodobiPogodbo(JsonObject postJsonObject)throws ParseException {
		int idOrder = postJsonObject.getInt("idOrder");
		Order order = uompz.getOrder(idOrder);

		int productID = Integer.parseInt(postJsonObject.getString("idPaketa"));
		int bonusReward = Integer.parseInt(postJsonObject.getString("bonusReward"));

		if (order != null) {
			order.setDateOfOrder(new Date());
			Product newProduct = new Product();
			newProduct.setProduct_ID(productID);
			order.getOrderdetails().get(0).setProduct(newProduct);;
			order.setBonusReward(bonusReward);
			uompz.updateOrder(order);
		}
	}
}
