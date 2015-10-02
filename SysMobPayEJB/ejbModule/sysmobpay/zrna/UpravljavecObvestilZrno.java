package sysmobpay.zrna;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import SysMobPayModel.Address;
import SysMobPayModel.Order;
import SysMobPayModel.Orderdetail;
import SysMobPayModel.User;

/**
 * Session Bean implementation class UpravljavecObvestilZrno
 */
@Stateless
public class UpravljavecObvestilZrno implements UpravljavecObvestilZrnoRemote, UpravljavecObvestilZrnoLocal {

	@PersistenceContext(unitName = "SysMobPayPU")
	private EntityManager em;
    
	
    public UpravljavecObvestilZrno() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @RolesAllowed({ "User", "Administrator", "System" })
    public void prepareReceipt(Order order){
    	User user = order.getUser();
    	Address add = user.getAddresses().get(0);
    	System.out.println("<html>\n");
    	System.out.println("<head>\n");
    	System.out.println("<title>Receipt</title>\n");
    	System.out.println("</head>\n");
    	System.out.println("<body>\n");
    	System.out.println("<center><h1>Receipt</h1></center>\n");
    	System.out.println("<ul>\n");
    	System.out.println("<li>Name: "+user.getName()+"</li>\n");
    	System.out.println("<li>Surname: "+user.getLastname()+"</li>\n");
    	System.out.println("<li>Address: "+add.getStreet()+" "+add.getNumber()+", "+add.getPostalCode()
    			+" "+add.getCity()+", "+add.getCountry()+"</li>\n");
    	System.out.println("<li>Phone no.: "+user.getPhone()+"</li>\n");    	
    	System.out.println("<li>List of orders: \n");
    	System.out.println("<ul>\n");
    	for(Orderdetail o:order.getOrderdetails()){
    		double price = o.getProduct().getPrice().doubleValue()*o.getQuantity();
    		System.out.println("<li>Company: "+o.getProduct().getCompany().getName()+"\nProduct: "
    				+ o.getProduct().getProductName()+"\nDescription: "+o.getProduct().getDecription()
    				+ "\nPrice: "+price+"\nBonus reward: "+o.getProduct().getBonusPoints()+"</li>\n");
    	}
    	System.out.println("</ul>\n");
    	System.out.println("</li>\n");
    	System.out.println("</ul>\n");
    	System.out.println("</body>\n");
    	System.out.println("</html>\n");
    }
}
