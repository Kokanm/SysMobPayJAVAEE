

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import sysmobpay.napake.NedovoljeniPogojiPlacilaException;
import sysmobpay.zrna.UpravljavecObdelaveMobilnihPlacilZrnoLocal;
import SysMobPayModel.Address;
import SysMobPayModel.Company;
import SysMobPayModel.Order;
import SysMobPayModel.Orderdetail;
import SysMobPayModel.Product;
import SysMobPayModel.User;

/**
 * Servlet implementation class EJBTestServlet
 */
@WebServlet("/EJBTestServlet")
public class EJBTestServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@EJB
	private UpravljavecObdelaveMobilnihPlacilZrnoLocal uompz;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EJBTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Order order = new Order();
		order.setOrder_ID(1);
		order.setBonusUsed(15);
		
		User user = new User();
		user.setUser_ID(3);
		user.setName("Joda");
		user.setLastname("Jedaioski");
		user.setCredit(new BigDecimal("29.31"));
		user.setPhone("253-555");
		user.setEmail("jj@hmail.com");
		user.setBonusPoints(20);
		user.setMaxDaily(new BigDecimal("1000"));		
		
		Address ad = new Address();
		ad.setAddress_ID(1);
		ad.setCity("Ljubljana");
		ad.setCountry("Slovenia");
		ad.setNumber(7);
		ad.setPostalCode("1000");
		ad.setStreet("Levstikov Trg");
		List<Address> ads = new ArrayList<>();
		ads.add(ad);		
		user.setAddresses(ads);
		order.setUser(user);		
		order.setAddress(ad);
		
		List<Orderdetail> orderList = new ArrayList<>();
		Orderdetail orderdetail = new Orderdetail();
		Product prod1 = new Product();
		prod1.setProduct_ID(3);
		prod1.setPrice(new BigDecimal("49.98"));
		prod1.setProductName("GTA V");
		prod1.setDecription("Game of the year!");
		prod1.setBonusPoints(10);
		
		Company c = new Company();
		c.setName("Rockstar");
		prod1.setCompany(c);
		
		orderdetail.setProduct(prod1);
		orderdetail.setUnitPrice(prod1.getPrice());
		orderdetail.setQuantity(2);
		orderdetail.setBonusPoints(prod1.getBonusPoints());
		orderdetail.setOrder(order);
		orderList.add(orderdetail);

		orderdetail = new Orderdetail();	
		Product prod2 = new Product();
		prod2.setProduct_ID(4);
		prod2.setPrice(new BigDecimal("300.28"));
		prod2.setProductName("Playstation 4");
		prod2.setDecription("Gaming console!");
		prod2.setBonusPoints(110);
		
		Company c2 = new Company();
		c2.setName("Sony");
		prod2.setCompany(c2);
		
		orderdetail.setProduct(prod2);
		orderdetail.setUnitPrice(prod2.getPrice());
		orderdetail.setQuantity(1);
		orderdetail.setBonusPoints(prod2.getBonusPoints());
		orderdetail.setOrder(order);
		orderList.add(orderdetail);

		order.setOrderdetails(orderList);
		
		BigDecimal BD = BigDecimal.ZERO;
		order.setPrice(BD);
		order.setBonusReward(0);
		for(Orderdetail o:order.getOrderdetails()){
			order.setPrice(order.getPrice().add(o.getUnitPrice().multiply(new BigDecimal(o.getQuantity()))));
			order.setBonusReward(order.getBonusReward()+o.getBonusPoints()*o.getQuantity());
		}
		order.setTaxPrice(order.getPrice().add(order.getPrice().multiply(new BigDecimal("18"))));
		
		try {
			order = uompz.purchaseProcess(order);
		} catch (NedovoljeniPogojiPlacilaException e) {
			e.printStackTrace();
		}
		
		user.setBonusPoints(user.getBonusPoints()+order.getBonusReward()-order.getBonusUsed());
		System.out.println("Bonus points left: "+user.getBonusPoints());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
